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
import android.support.v4.app.QFragmentActivity;
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
import com.tencent.mobileqq.troop.api.ITroopGagService;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
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
  private boolean b;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = true;
  private View jdField_d_of_type_AndroidViewView;
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private boolean h = true;
  private boolean i;
  private boolean j;
  
  @NonNull
  private Intent a(Object[] paramArrayOfObject)
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent == null) {
      localIntent = new Intent();
    }
    for (;;)
    {
      if ((paramArrayOfObject.length == 4) && ((paramArrayOfObject[2] instanceof Long)) && ((paramArrayOfObject[3] instanceof Integer)))
      {
        localIntent.putExtra("KEY_WRITE_TOGETHER_MSG_SEQ", (Long)paramArrayOfObject[2]);
        localIntent.putExtra("KEY_WRITE_TOGETHER_MSG_RANDOM", (Integer)paramArrayOfObject[3]);
      }
      localIntent.putExtra("KEY_WRITE_TOGETHER_GROUPUIN", this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
      return localIntent;
    }
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
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam != null)
    {
      str1 = str2;
      if (WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a() != CreatingState.TEMPLATE_SHOW_ENTRANCE) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.b() == CreatingState.TEMPLATE_SHOW_LAYER)) {
          break label58;
        }
        str1 = "1000";
      }
    }
    label58:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null);
      str1 = str2;
    } while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter() == null);
    return String.valueOf(((HorizontalAdapter)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter()).a());
  }
  
  public static void a(Activity paramActivity, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle, int paramInt)
  {
    if (jdField_d_of_type_Boolean) {}
    label75:
    do
    {
      do
      {
        return;
        if ((paramActivity != null) && (paramClass != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      paramBundle = new StringBuilder();
      if (paramActivity == null)
      {
        paramActivity = "context ";
        paramBundle = paramBundle.append(paramActivity);
        if (paramClass != null) {
          break label75;
        }
      }
      for (paramActivity = "fragment ";; paramActivity = "")
      {
        QLog.d("WriteTogetherEditorFragment", 2, paramActivity + "is null");
        return;
        paramActivity = "";
        break;
      }
      Intent localIntent = new Intent();
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      QPublicFragmentActivity.Launcher.a(paramActivity, localIntent, QPublicFragmentActivity.class, paramClass, paramInt);
      jdField_d_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.2(), 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherEditorFragment", 2, "start fragment: " + paramClass.getName());
  }
  
  public static void a(Context paramContext, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle)
  {
    if (jdField_d_of_type_Boolean) {}
    label75:
    do
    {
      do
      {
        return;
        if ((paramContext != null) && (paramClass != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      paramBundle = new StringBuilder();
      if (paramContext == null)
      {
        paramContext = "context ";
        paramBundle = paramBundle.append(paramContext);
        if (paramClass != null) {
          break label75;
        }
      }
      for (paramContext = "fragment ";; paramContext = "")
      {
        QLog.d("WriteTogetherEditorFragment", 2, paramContext + "is null");
        return;
        paramContext = "";
        break;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456);
      localIntent.addFlags(536870912);
      localIntent.addFlags(67108864);
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      QPublicFragmentActivity.Launcher.a(paramContext, localIntent, QPublicFragmentActivity.class, paramClass);
      jdField_d_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.1(), 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherEditorFragment", 2, "start fragment: " + paramClass.getName());
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
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "[doOpenFailed] errno: " + k);
    }
    if (k == 154)
    {
      c(paramOpenDocParam);
      return;
    }
    if (k == 1281)
    {
      l();
      return;
    }
    if (k == 1282)
    {
      l();
      return;
    }
    if (k == 1283)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.LIMITED);
      return;
    }
    if (k == 1284)
    {
      l();
      return;
    }
    if (k == 1285)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131720733), this.jdField_a_of_type_AndroidContentContext.getString(2131720744));
      return;
    }
    if (k == 1286)
    {
      l();
      return;
    }
    if (k == 1287)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131720743), this.jdField_a_of_type_AndroidContentContext.getString(2131720741));
      return;
    }
    l();
    QLog.e("WriteTogetherEditorFragment", 1, "[doOpenFailed] error code unhandled: " + k);
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
    Resources localResources;
    if (!paramBoolean)
    {
      this.j = false;
      t();
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (paramCreateDocParam.jdField_a_of_type_Int == 1286)
      {
        WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131720736), localResources.getString(2131720744), null);
        k_(false);
      }
    }
    else
    {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131720749), 0).a();
  }
  
  private void a(boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (paramBoolean) {
      b(paramOpenDocParam);
    }
    for (;;)
    {
      if (!WriteTogetherConfBean.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.LIMITED);
      }
      return;
      a(paramOpenDocParam);
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
    if (this.jdField_b_of_type_Boolean) {
      QLog.w("WriteTogetherEditorFragment", 1, "doc is opened already");
    }
    do
    {
      return;
      ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(paramOpenDocParam.jdField_a_of_type_JavaLangString, paramOpenDocParam.jdField_b_of_type_JavaLangString, paramOpenDocParam.c);
      String str = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k;
      int k = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int;
      int m = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.g;
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam = paramOpenDocParam;
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k = str;
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int = k;
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.g = m;
      d(paramOpenDocParam);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.i);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.e);
      WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.e);
    } while (!WriteTogetherUtils.a());
    p();
  }
  
  private void c(int paramInt)
  {
    WriteTogetherTemplateConfBean.Template[] arrayOfTemplate = WriteTogetherTemplateConfProcessor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
    if ((arrayOfTemplate == null) || (arrayOfTemplate.length == 0)) {
      b(paramInt);
    }
    while ((!WriteTogetherUtils.a(paramInt)) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a() != CreatingState.TEMPLATE_NO)) {
      return;
    }
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
  
  private void c(OpenDocParam paramOpenDocParam)
  {
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "retry times: " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  private void d(OpenDocParam paramOpenDocParam)
  {
    IQQWriteTogetherService localIQQWriteTogetherService = (IQQWriteTogetherService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQWriteTogetherService.class, "");
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient = new ChangesetClient(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
      this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.a(new ChangesetScheduler());
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.a(this);
      localIQQWriteTogetherService.addObservers(this);
      localIQQWriteTogetherService.init(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k, paramOpenDocParam.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.a(paramOpenDocParam.jdField_b_of_type_Int);
    localIQQWriteTogetherService.updateRev(paramOpenDocParam.jdField_b_of_type_Int);
  }
  
  private boolean i()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataDocMetaData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
  }
  
  private boolean j()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString));
  }
  
  private void l()
  {
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131720742), this.jdField_a_of_type_AndroidContentContext.getString(2131720741));
  }
  
  private void m()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    if (!WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int)) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setVisibility(0);
  }
  
  private void n()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.a())) && (this.h))
    {
      k_(true);
      return;
    }
    k_(false);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.c();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.e();
    ReportController.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k), 0, "1", "", this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
  }
  
  private void p()
  {
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity != null)
    {
      WriteTogetherUtils.a(localQFragmentActivity, new WriteTogetherEditorFragment.7(this));
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.f();
    }
  }
  
  private void q()
  {
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)b().findViewById(2131379532));
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167030);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(k);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView = ((WriteTogetherEditorView)this.jdField_b_of_type_AndroidViewView.findViewById(2131366439));
    k = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167095);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setTextColor(k);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setEnabled(false);
    a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView);
    a(getResources().getString(2131720727), new WriteTogetherEditorFragment.9(this));
    Object localObject = getArguments();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("KEY_CANCEL_OR_BACK");
      if ((localObject != null) && (((String)localObject).equals("VALUE_CANCEL"))) {
        a(2131720698, new WriteTogetherEditorFragment.10(this));
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    this.jdField_d_of_type_AndroidWidgetTextView.requestLayout();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131382064));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370704);
    this.jdField_d_of_type_AndroidViewView = a(HardCodeUtil.a(2131720726), 2131563245);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar = new UserStateBar(this.jdField_a_of_type_AndroidContentContext, this.jdField_d_of_type_AndroidViewView, this.jdField_f_of_type_AndroidWidgetTextView);
  }
  
  private void r()
  {
    WriteTogetherOidbHandlerImpl localWriteTogetherOidbHandlerImpl = (WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME);
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k;
    }
    for (int k = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int;; k = 0)
    {
      int m;
      if ((!TextUtils.isEmpty(str)) || (WriteTogetherUtils.a(k)))
      {
        localWriteTogetherOidbHandlerImpl.createDoc(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(), str);
        k = 1;
        m = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str);
        if (k == 0) {
          break label167;
        }
      }
      label167:
      for (str = "1";; str = "2")
      {
        ReportController.b(null, "dc00898", "", "", "0X800AF33", "0X800AF33", m, 0, str, a(), "", "");
        return;
        DocMetaData localDocMetaData = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
        if (localDocMetaData != null)
        {
          if (TextUtils.isEmpty(localDocMetaData.jdField_b_of_type_JavaLangString)) {}
          localWriteTogetherOidbHandlerImpl.sendWtMessage(localDocMetaData.jdField_b_of_type_JavaLangString, "", 0, str);
        }
        k = 0;
        break;
      }
      str = "";
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, 0, 2131561412, 17);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setContentView(2131562946);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在发送");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    k_(false);
  }
  
  private void t()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if ((!this.jdField_f_of_type_Boolean) && (this.h)) {
      k_(true);
    }
  }
  
  private void u()
  {
    int k;
    if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController != null) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.b()))
    {
      localObject = new WriteTogetherEditorFragment.11(this);
      WriteTogetherEditorFragment.12 local12 = new WriteTogetherEditorFragment.12(this);
      WriteTogetherUtils.a(getActivity(), (DialogInterface.OnClickListener)localObject, local12);
      k = WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)) {
        break label117;
      }
    }
    label117:
    for (Object localObject = "1";; localObject = "2")
    {
      ReportController.b(null, "dc00898", "", "", "0X800AF32", "0X800AF32", k, 0, (String)localObject, "", "", "");
      return;
      getActivity().finish();
      v();
      break;
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam != null) && (WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int))) {
      getActivity().overridePendingTransition(2130771998, 2130772003);
    }
  }
  
  private void w()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.16(this), 100L);
  }
  
  public int a()
  {
    return 2131561090;
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
      r();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(paramInt, paramString);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.a(paramInt, paramString);
    if (this.j)
    {
      this.j = false;
      t();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131720749), 0).a();
    }
  }
  
  public void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    q();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController = new EditorController(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
    paramLayoutInflater = getArguments();
    OpenDocParam localOpenDocParam;
    if (paramLayoutInflater != null)
    {
      localOpenDocParam = (OpenDocParam)paramLayoutInflater.get("KEY_LAUNCH_EDITOR_PARAM");
      if (localOpenDocParam != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(localOpenDocParam.k);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(localOpenDocParam.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam = localOpenDocParam;
        k();
        paramViewGroup = localOpenDocParam.jdField_a_of_type_JavaLangString;
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup == null) {
          paramLayoutInflater = "";
        }
        a(localOpenDocParam, localOpenDocParam.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.b(paramLayoutInflater);
        n();
        paramBundle = new AttribPool();
        if (!TextUtils.isEmpty(localOpenDocParam.jdField_b_of_type_JavaLangString)) {
          break label481;
        }
      }
    }
    label481:
    for (paramLayoutInflater = Changeset.a(paramLayoutInflater, Arrays.asList(new Pair[] { new Pair("author", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()) }), paramBundle);; paramLayoutInflater = Changeset.a(paramLayoutInflater, localOpenDocParam.jdField_b_of_type_JavaLangString))
    {
      paramViewGroup = "";
      if (!"0".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())) {
        paramViewGroup = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount();
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel = new EditorModel(paramLayoutInflater, paramBundle, paramViewGroup, "");
      this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker = new ChangesetTracker(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(), this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.setClient(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(this.jdField_a_of_type_ComTencentMobileqqEasysync2ChangesetTracker);
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController = new UserStateController(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int, getActivity());
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
      return;
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
      }
    }
    else
    {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if ((paramBoolean) || (!this.h)) {
      k_(false);
    }
    while (!this.jdField_d_of_type_AndroidWidgetTextView.isEnabled()) {
      return;
    }
    k_(true);
  }
  
  public void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean) || (this.jdField_g_of_type_Boolean)) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (paramBoolean) {
      if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131720729));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.d();
      m();
      if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.a(((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uid, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      if (WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.CLOSED_BY_ADMIN, getString(2131720730));
      return;
      if (a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k))
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131720739));
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.READY);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(EditorState.LIMITED);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      n();
      return;
    }
    k_(paramBoolean1);
  }
  
  public void aF_()
  {
    QFragmentActivity localQFragmentActivity = getActivity();
    if ((localQFragmentActivity != null) && (!localQFragmentActivity.isFinishing()))
    {
      WriteTogetherUtils.a(localQFragmentActivity, new WriteTogetherEditorFragment.15(this));
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.f();
    }
  }
  
  public void b()
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
    m();
  }
  
  public boolean c()
  {
    u();
    return true;
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
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView.getText())) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      ((HorizontalAdapter)localObject).a(bool);
      ((HorizontalAdapter)localObject).a(0);
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.18(this, (TranslateAnimation)localObject), 100L);
      return;
    }
  }
  
  public void i_(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.a(paramBoolean);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter() != null) {
        ReportController.b(null, "dc00898", "", "", "0X800B356", "0X800B356", ((HorizontalAdapter)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter()).a(), 0, String.valueOf(WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k)), "", "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(0);
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.e();
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
  
  public void j_(boolean paramBoolean)
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
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.17(this), 100L);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void k()
  {
    this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370421);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370422);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368843));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnTouchListener(new WriteTogetherEditorFragment.13(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new WriteTogetherEditorFragment.14(this));
    HorizontalAdapter localHorizontalAdapter = new HorizontalAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiWriteTogetherEditorView, WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376819));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(localHorizontalAdapter);
    localHorizontalAdapter.a(WriteTogetherTemplateConfProcessor.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver = a();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController = new EditorStateMachineController(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getActivity(), this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.a();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController = new CreatingStateMachineController(this);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCreatingStateMachineController.a();
    paramBundle = getActivity();
    if ((paramBundle != null) && (paramBundle.getWindow() != null)) {
      paramBundle.getWindow().setSoftInputMode(16);
    }
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = (OpenDocParam)paramBundle.get("KEY_LAUNCH_EDITOR_PARAM");
      if ((paramBundle != null) && (WriteTogetherUtils.a(paramBundle.jdField_f_of_type_Int))) {
        getActivity().overridePendingTransition(2130771999, 2130772002);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((j()) && (i()) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController != null) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.c()) && (NetworkUtil.a())) {
      ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).sendGrayTip(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqWritetogetherWriteTogetherOidbObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientEditorController.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineEditorStateMachineController.b();
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientChangesetClient.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController != null) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController.c();
    }
    IQQWriteTogetherService localIQQWriteTogetherService = (IQQWriteTogetherService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQWriteTogetherService.class, "");
    localIQQWriteTogetherService.removeObserver(this);
    localIQQWriteTogetherService.stop();
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler != null) {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
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
    String str2 = "" + WriteTogetherUtils.a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString == null) {}
    for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)
    {
      ReportController.b(null, "dc00898", "", "", "0X800AF30", "0X800AF30", k, 0, str2, "", str1, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment
 * JD-Core Version:    0.7.0.1
 */