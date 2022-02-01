package com.tencent.mobileqq.writetogetherui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.easysync2.AttribPool;
import com.tencent.mobileqq.easysync2.Changeset;
import com.tencent.mobileqq.easysync2.ChangesetTracker;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.IAnonymousChatApi;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.data.SelfGagInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.WriteTogetherOidbObserver;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.api.impl.WriteTogetherOidbHandlerImpl;
import com.tencent.mobileqq.writetogether.client.ChangesetClient;
import com.tencent.mobileqq.writetogether.client.ChangesetScheduler;
import com.tencent.mobileqq.writetogether.client.EditorController;
import com.tencent.mobileqq.writetogether.client.IOnChangesetCommit;
import com.tencent.mobileqq.writetogether.client.UserStateController;
import com.tencent.mobileqq.writetogether.client.UserStateController.OnCharacterOverSizeListener;
import com.tencent.mobileqq.writetogether.client.UserStateController.OnUserNewInfoListener;
import com.tencent.mobileqq.writetogether.data.CreateDocParam;
import com.tencent.mobileqq.writetogether.data.CursorManager;
import com.tencent.mobileqq.writetogether.data.DocMetaData;
import com.tencent.mobileqq.writetogether.data.EditorModel;
import com.tencent.mobileqq.writetogether.data.IEditorModel;
import com.tencent.mobileqq.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.writetogether.data.UserEditInfo;
import com.tencent.mobileqq.writetogether.statemachine.CreatingState;
import com.tencent.mobileqq.writetogether.statemachine.CreatingStateMachineController;
import com.tencent.mobileqq.writetogether.statemachine.EditorState;
import com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController;
import com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg.Header;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherConfBean;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class WriteTogetherEditorFragment
  extends QIphoneTitleBarFragment
  implements IWriteTogetherObserver, IOnChangesetCommit, UserStateController.OnCharacterOverSizeListener, UserStateController.OnUserNewInfoListener, DocRefresher, EditableModifier, ITemplateWhenCreating, WriteTogetherEditorView.OnEditorClickEventListener
{
  private static boolean jdField_d_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ChangesetTracker jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private WriteTogetherOidbObserver jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver;
  private ChangesetClient jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient;
  private EditorController jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController;
  private UserStateController jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController;
  private DocMetaData jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData;
  private IEditorModel jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
  private OpenDocParam jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam;
  private CreatingStateMachineController jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController;
  EditorStateMachineController jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController;
  private UserStateBar jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar;
  private WriteTogetherEditorView jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WriteTogetherEditorFragment.5(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean = true;
  private boolean i;
  private boolean j;
  
  @NonNull
  private Intent a(Object[] paramArrayOfObject)
  {
    Intent localIntent2 = getQBaseActivity().getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null) {
      localIntent1 = new Intent();
    }
    if ((paramArrayOfObject.length == 4) && ((paramArrayOfObject[2] instanceof Long)) && ((paramArrayOfObject[3] instanceof Integer)))
    {
      localIntent1.putExtra("KEY_WRITE_TOGETHER_MSG_SEQ", (Long)paramArrayOfObject[2]);
      localIntent1.putExtra("KEY_WRITE_TOGETHER_MSG_RANDOM", (Integer)paramArrayOfObject[3]);
    }
    localIntent1.putExtra("KEY_WRITE_TOGETHER_GROUPUIN", this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
    return localIntent1;
  }
  
  private WriteTogetherOidbObserver a()
  {
    return new WriteTogetherEditorFragment.3(this);
  }
  
  private UserEditInfo a(AppRuntime paramAppRuntime, EditText paramEditText)
  {
    UserEditInfo localUserEditInfo = new UserEditInfo();
    localUserEditInfo.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    localUserEditInfo.jdField_a_of_type_Boolean = false;
    localUserEditInfo.c = paramEditText.getSelectionStart();
    localUserEditInfo.d = paramEditText.getSelectionEnd();
    return localUserEditInfo;
  }
  
  private String a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam;
    if ((localObject != null) && (WriteTogetherUtils.a(((OpenDocParam)localObject).jdField_f_of_type_Int)))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a() == CreatingState.TEMPLATE_SHOW_ENTRANCE) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.b() != CreatingState.TEMPLATE_SHOW_LAYER)) {
        return "1000";
      }
      localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
      if ((localObject != null) && (((RecyclerView)localObject).getAdapter() != null)) {
        return String.valueOf(((HorizontalAdapter)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter()).a());
      }
    }
    return "";
  }
  
  public static void a(Activity paramActivity, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle, int paramInt)
  {
    if (jdField_d_of_type_Boolean) {
      return;
    }
    Object localObject;
    if ((paramActivity != null) && (paramClass != null))
    {
      localObject = new Intent();
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      QPublicFragmentActivity.Launcher.a(paramActivity, (Intent)localObject, QPublicFragmentActivity.class, paramClass, paramInt);
      jdField_d_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.2(), 1000L);
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("start fragment: ");
        paramActivity.append(paramClass.getName());
        QLog.d("WriteTogetherEditorFragment", 2, paramActivity.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      paramBundle = "";
      if (paramActivity == null) {
        paramActivity = "context ";
      } else {
        paramActivity = "";
      }
      ((StringBuilder)localObject).append(paramActivity);
      paramActivity = paramBundle;
      if (paramClass == null) {
        paramActivity = "fragment ";
      }
      ((StringBuilder)localObject).append(paramActivity);
      ((StringBuilder)localObject).append("is null");
      QLog.d("WriteTogetherEditorFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(Context paramContext, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle)
  {
    if (jdField_d_of_type_Boolean) {
      return;
    }
    Object localObject;
    if ((paramContext != null) && (paramClass != null))
    {
      localObject = new Intent();
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).addFlags(536870912);
      ((Intent)localObject).addFlags(67108864);
      if (paramBundle != null) {
        ((Intent)localObject).putExtras(paramBundle);
      }
      QPublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject, QPublicFragmentActivity.class, paramClass);
      jdField_d_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.1(), 1000L);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("start fragment: ");
        paramContext.append(paramClass.getName());
        QLog.d("WriteTogetherEditorFragment", 2, paramContext.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      paramBundle = "";
      if (paramContext == null) {
        paramContext = "context ";
      } else {
        paramContext = "";
      }
      ((StringBuilder)localObject).append(paramContext);
      paramContext = paramBundle;
      if (paramClass == null) {
        paramContext = "fragment ";
      }
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("is null");
      QLog.d("WriteTogetherEditorFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void a(TextView paramTextView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {
      paramTextView.setBreakStrategy(0);
    }
  }
  
  private void a(EditorController paramEditorController)
  {
    paramEditorController.a(new WriteTogetherEditorFragment.8(this));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setOnEditorClickEventListener(this);
  }
  
  private void a(EditorController paramEditorController, IEditorModel paramIEditorModel, UserEditInfo paramUserEditInfo, List<UserEditInfo> paramList)
  {
    paramUserEditInfo = new CursorManager(paramUserEditInfo, paramList);
    paramIEditorModel.a(paramUserEditInfo);
    paramUserEditInfo.a(paramEditorController);
  }
  
  private void a(OpenDocParam paramOpenDocParam)
  {
    int k = paramOpenDocParam.h;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doOpenFailed] errno: ");
      localStringBuilder.append(k);
      QLog.d("WriteTogetherEditorFragment", 2, localStringBuilder.toString());
    }
    if (k == 154)
    {
      c(paramOpenDocParam);
      return;
    }
    if (k == 1281)
    {
      h();
      return;
    }
    if (k == 1282)
    {
      h();
      return;
    }
    if (k == 1283)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.LIMITED);
      return;
    }
    if (k == 1284)
    {
      h();
      return;
    }
    if (k == 1285)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131720458), this.jdField_a_of_type_AndroidContentContext.getString(2131720469));
      return;
    }
    if (k == 1286)
    {
      h();
      return;
    }
    if (k == 1287)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131720468), this.jdField_a_of_type_AndroidContentContext.getString(2131720466));
      return;
    }
    h();
    paramOpenDocParam = new StringBuilder();
    paramOpenDocParam.append("[doOpenFailed] error code unhandled: ");
    paramOpenDocParam.append(k);
    QLog.e("WriteTogetherEditorFragment", 1, paramOpenDocParam.toString());
  }
  
  private void a(OpenDocParam paramOpenDocParam, int paramInt)
  {
    if (WriteTogetherUtils.a(paramInt))
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.CREATING);
      return;
    }
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, new WriteTogetherEditorFragment.4(this));
  }
  
  private void a(boolean paramBoolean, CreateDocParam paramCreateDocParam)
  {
    if (!paramBoolean)
    {
      this.j = false;
      p();
      Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (paramCreateDocParam.jdField_a_of_type_Int == 1286)
      {
        WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131720461), localResources.getString(2131720469), null);
        i_(false);
        return;
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131720474), 0).a();
    }
  }
  
  private void a(boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (paramBoolean) {
      b(paramOpenDocParam);
    } else {
      a(paramOpenDocParam);
    }
    if (!WriteTogetherConfBean.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.LIMITED);
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    return ((ITroopGagService)paramAppRuntime.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(paramString, true).jdField_a_of_type_Boolean;
  }
  
  private void b(int paramInt)
  {
    if (WriteTogetherUtils.a(paramInt)) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.6(this), 1000L);
    }
  }
  
  private void b(OpenDocParam paramOpenDocParam)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("WriteTogetherEditorFragment", 1, "doc is opened already");
      return;
    }
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(paramOpenDocParam.jdField_a_of_type_JavaLangString, paramOpenDocParam.jdField_b_of_type_JavaLangString, paramOpenDocParam.c);
    String str = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k;
    int k = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int;
    int m = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.g;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam = paramOpenDocParam;
    OpenDocParam localOpenDocParam = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam;
    localOpenDocParam.k = str;
    localOpenDocParam.jdField_f_of_type_Int = k;
    localOpenDocParam.g = m;
    d(paramOpenDocParam);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.i);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.e);
    WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.e);
    if (WriteTogetherUtils.a()) {
      l();
    }
  }
  
  private boolean b()
  {
    DocMetaData localDocMetaData = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData;
    return (localDocMetaData != null) && (!TextUtils.isEmpty(localDocMetaData.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
  }
  
  private void c(int paramInt)
  {
    WriteTogetherTemplateConfBean.Template[] arrayOfTemplate = WriteTogetherTemplateConfProcessor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
    if ((arrayOfTemplate != null) && (arrayOfTemplate.length != 0))
    {
      if ((WriteTogetherUtils.a(paramInt)) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a() == CreatingState.TEMPLATE_NO))
      {
        if (WriteTogetherUtils.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a(CreatingState.TEMPLATE_FIRST_USE);
          return;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.a()))
        {
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a(CreatingState.TEMPLATE_SHOW_LAYER);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
      }
    }
    else {
      b(paramInt);
    }
  }
  
  private void c(OpenDocParam paramOpenDocParam)
  {
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    if (QLog.isColorLevel())
    {
      paramOpenDocParam = new StringBuilder();
      paramOpenDocParam.append("retry times: ");
      paramOpenDocParam.append(this.jdField_a_of_type_Int);
      QLog.d("WriteTogetherEditorFragment", 2, paramOpenDocParam.toString());
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  private boolean c()
  {
    OpenDocParam localOpenDocParam = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam;
    return (localOpenDocParam != null) && (!TextUtils.isEmpty(localOpenDocParam.jdField_f_of_type_JavaLangString));
  }
  
  private void d(OpenDocParam paramOpenDocParam)
  {
    IQQWriteTogetherService localIQQWriteTogetherService = (IQQWriteTogetherService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQWriteTogetherService.class, "");
    ChangesetClient localChangesetClient = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient;
    if (localChangesetClient == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient = new ChangesetClient(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
      this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.a(new ChangesetScheduler());
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.a(this);
      localIQQWriteTogetherService.addObservers(this);
      localIQQWriteTogetherService.init(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k, paramOpenDocParam.jdField_b_of_type_Int);
      return;
    }
    localChangesetClient.a(paramOpenDocParam.jdField_b_of_type_Int);
    localIQQWriteTogetherService.updateRev(paramOpenDocParam.jdField_b_of_type_Int);
  }
  
  private void h()
  {
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131720467), this.jdField_a_of_type_AndroidContentContext.getString(2131720466));
  }
  
  private void i()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if (!WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int)) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setVisibility(0);
  }
  
  private void j()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.a())) && (this.jdField_h_of_type_Boolean))
    {
      i_(true);
      return;
    }
    i_(false);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.c();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.e();
    ReportController.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k), 0, "1", "", this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
  }
  
  private void l()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null)
    {
      WriteTogetherUtils.a(localQBaseActivity, new WriteTogetherEditorFragment.7(this));
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.f();
    }
  }
  
  private void m()
  {
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)c().findViewById(2131378880));
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167053);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(k);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView = ((WriteTogetherEditorView)this.b.findViewById(2131366320));
    k = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167118);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setTextColor(k);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setEnabled(false);
    a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView);
    b(getResources().getString(2131720452), new WriteTogetherEditorFragment.9(this));
    Object localObject = getArguments();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("KEY_CANCEL_OR_BACK");
      if ((localObject != null) && (((String)localObject).equals("VALUE_CANCEL"))) {
        a(2131720417, new WriteTogetherEditorFragment.10(this));
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_d_of_type_AndroidWidgetTextView.requestLayout();
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131381266));
    this.jdField_c_of_type_AndroidViewView = this.b.findViewById(2131370343);
    this.jdField_d_of_type_AndroidViewView = a(HardCodeUtil.a(2131720451), 2131563069);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar = new UserStateBar(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_AndroidViewView, this.jdField_g_of_type_AndroidWidgetTextView);
  }
  
  private void n()
  {
    WriteTogetherOidbHandlerImpl localWriteTogetherOidbHandlerImpl = (WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam;
    int m = 0;
    int k;
    if (localObject != null)
    {
      localObject = ((OpenDocParam)localObject).k;
      k = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int;
    }
    else
    {
      localObject = "";
      k = 0;
    }
    TextUtils.isEmpty((CharSequence)localObject);
    if (WriteTogetherUtils.a(k))
    {
      k = 1;
      localWriteTogetherOidbHandlerImpl.createDoc(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(), (String)localObject);
    }
    else
    {
      DocMetaData localDocMetaData = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
      k = m;
      if (localDocMetaData != null)
      {
        TextUtils.isEmpty(localDocMetaData.jdField_b_of_type_JavaLangString);
        localWriteTogetherOidbHandlerImpl.sendWtMessage(localDocMetaData.jdField_b_of_type_JavaLangString, "", 0, (String)localObject);
        k = m;
      }
    }
    m = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (String)localObject);
    if (k != 0) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF33", "0X800AF33", m, 0, (String)localObject, a(), "", "");
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, 0, 2131561251, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562765);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在发送");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    i_(false);
  }
  
  private void p()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((!this.jdField_f_of_type_Boolean) && (this.jdField_h_of_type_Boolean)) {
      i_(true);
    }
  }
  
  private void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController;
    if ((localObject != null) && (((EditorController)localObject).b()))
    {
      localObject = new WriteTogetherEditorFragment.11(this);
      WriteTogetherEditorFragment.12 local12 = new WriteTogetherEditorFragment.12(this);
      WriteTogetherUtils.a(getQBaseActivity(), (DialogInterface.OnClickListener)localObject, local12);
    }
    else
    {
      getQBaseActivity().finish();
      r();
    }
    int k = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF32", "0X800AF32", k, 0, (String)localObject, "", "", "");
  }
  
  private void r()
  {
    OpenDocParam localOpenDocParam = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam;
    if ((localOpenDocParam != null) && (WriteTogetherUtils.a(localOpenDocParam.jdField_f_of_type_Int))) {
      getQBaseActivity().overridePendingTransition(2130772010, 2130772015);
    }
  }
  
  private void s()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.16(this), 100L);
  }
  
  protected int a()
  {
    return 2131560954;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b(paramInt);
    if (!this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker.a()) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a();
    }
    if ((this.j) && (!this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker.a())) {
      n();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(paramInt, paramString);
    if (this.j)
    {
      this.j = false;
      p();
      paramString = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(paramString, paramString.getResources().getString(2131720474), 0).a();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    m();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController = new EditorController(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      OpenDocParam localOpenDocParam = (OpenDocParam)paramLayoutInflater.get("KEY_LAUNCH_EDITOR_PARAM");
      if (localOpenDocParam != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(localOpenDocParam.k);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(localOpenDocParam.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam = localOpenDocParam;
        g();
        paramViewGroup = localOpenDocParam.jdField_a_of_type_JavaLangString;
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup == null) {
          paramLayoutInflater = "";
        }
        a(localOpenDocParam, localOpenDocParam.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.b(paramLayoutInflater);
        j();
        paramBundle = new AttribPool();
        if (TextUtils.isEmpty(localOpenDocParam.jdField_b_of_type_JavaLangString)) {
          paramLayoutInflater = Changeset.a(paramLayoutInflater, Arrays.asList(new Pair[] { new Pair("author", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()) }), paramBundle);
        } else {
          paramLayoutInflater = Changeset.a(paramLayoutInflater, localOpenDocParam.jdField_b_of_type_JavaLangString);
        }
        if (!"0".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())) {
          paramViewGroup = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
        } else {
          paramViewGroup = "";
        }
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel = new EditorModel(paramLayoutInflater, paramBundle, paramViewGroup, "");
        this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker = new ChangesetTracker(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(), this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setClient(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController = new UserStateController(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int, getQBaseActivity());
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(this);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(this);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), "");
        paramLayoutInflater = a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView);
        a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel, paramLayoutInflater, new ArrayList());
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new WriteTogetherEditorFragment.MyNetInfoHandler(this, null);
        AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
        c(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int);
      }
    }
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    if (paramType == Type.CLIENT_READY)
    {
      paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
      if ((paramType.result != 0) && (paramType.result != 60009))
      {
        this.jdField_c_of_type_Boolean = false;
        a(paramType.result, paramType.errMsg);
        return;
      }
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if ((!paramBoolean) && (this.jdField_h_of_type_Boolean))
    {
      if (this.jdField_d_of_type_AndroidWidgetTextView.isEnabled()) {
        i_(true);
      }
    }
    else {
      i_(false);
    }
  }
  
  public void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      if (this.jdField_g_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      if (paramBoolean)
      {
        if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131720454));
        } else if (a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131720464));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.READY);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.LIMITED);
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.d();
      i();
      if (paramBoolean)
      {
        ChangesetClient localChangesetClient = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient;
        if (localChangesetClient != null) {
          localChangesetClient.a(((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uid, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      if (!WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.CLOSED_BY_ADMIN, getString(2131720455));
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      j();
      return;
    }
    i_(paramBoolean1);
  }
  
  public void aU_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam == null)
    {
      QLog.w("WriteTogetherEditorFragment", 1, "refresh failed, param is null");
      return;
    }
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
  }
  
  public void c()
  {
    i();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setCursorVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.requestFocus();
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView, 0);
      }
    }
    else
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.17(this), 100L);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void d()
  {
    Object localObject = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.getContext().getSystemService("input_method");
    if (localObject != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.getWindowToken(), 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setCursorVisible(false);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter() != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
      localObject = (HorizontalAdapter)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
      ((HorizontalAdapter)localObject).a(TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.getText()) ^ true);
      ((HorizontalAdapter)localObject).a(0);
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.18(this, (TranslateAnimation)localObject), 100L);
  }
  
  public void e()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      WriteTogetherUtils.a(localQBaseActivity, new WriteTogetherEditorFragment.15(this));
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.f();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter() != null) {
        ReportController.b(null, "dc00898", "", "", "0X800B356", "0X800B356", ((HorizontalAdapter)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter()).a(), 0, String.valueOf(WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)), "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(0);
    UserStateController localUserStateController = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController;
    if (localUserStateController != null) {
      localUserStateController.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a() == EditorState.READY)
    {
      if (!this.jdField_e_of_type_Boolean) {
        ReportController.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k), 0, "2", "", this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.ACTIVATED);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(true);
  }
  
  public void g()
  {
    this.jdField_e_of_type_AndroidViewView = this.b.findViewById(2131370080);
    this.jdField_f_of_type_AndroidViewView = this.b.findViewById(2131370081);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131368571));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(new WriteTogetherEditorFragment.13(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new WriteTogetherEditorFragment.14(this));
    HorizontalAdapter localHorizontalAdapter = new HorizontalAdapter(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView, WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getQBaseActivity());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.b.findViewById(2131376310));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(localHorizontalAdapter);
    localHorizontalAdapter.a(WriteTogetherTemplateConfProcessor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k));
  }
  
  public void k_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(paramBoolean);
  }
  
  public boolean onBackEvent()
  {
    q();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getQBaseActivity();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getQBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver = a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController = new EditorStateMachineController(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getQBaseActivity(), this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController = new CreatingStateMachineController(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a();
    paramBundle = getQBaseActivity();
    if ((paramBundle != null) && (paramBundle.getWindow() != null)) {
      paramBundle.getWindow().setSoftInputMode(16);
    }
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = (OpenDocParam)paramBundle.get("KEY_LAUNCH_EDITOR_PARAM");
      if ((paramBundle != null) && (WriteTogetherUtils.a(paramBundle.jdField_f_of_type_Int))) {
        getQBaseActivity().overridePendingTransition(2130772011, 2130772014);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((c()) && (b()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController;
      if ((localObject != null) && (((EditorController)localObject).c()) && (NetworkUtil.isNetworkAvailable())) {
        ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).sendGrayTip(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController;
    if (localObject != null) {
      ((EditorController)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.b();
    localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient;
    if (localObject != null) {
      ((ChangesetClient)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController;
    if (localObject != null) {
      ((UserStateController)localObject).c();
    }
    localObject = (IQQWriteTogetherService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQWriteTogetherService.class, "");
    ((IQQWriteTogetherService)localObject).removeObserver(this);
    ((IQQWriteTogetherService)localObject).stop();
    localObject = this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onResume()
  {
    super.onResume();
    int k = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int));
    String str = ((StringBuilder)localObject).toString();
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString == null) {
      localObject = "";
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF30", "0X800AF30", k, 0, str, "", (String)localObject, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment
 * JD-Core Version:    0.7.0.1
 */