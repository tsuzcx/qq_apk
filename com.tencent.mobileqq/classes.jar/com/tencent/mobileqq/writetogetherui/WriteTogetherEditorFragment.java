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
  private static boolean P = false;
  private CreatingStateMachineController A;
  private OpenDocParam B;
  private DocMetaData C;
  private int D = 0;
  private View E;
  private TextView F;
  private View G;
  private UserStateBar H;
  private TextView I;
  private RecyclerView J;
  private View K;
  private ImageView L;
  private View M;
  private boolean N;
  private boolean O = true;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T = true;
  private boolean U;
  private boolean V;
  private INetInfoHandler W;
  private Runnable X = new WriteTogetherEditorFragment.5(this);
  EditorStateMachineController a;
  QQProgressDialog b;
  private Context c;
  private AppInterface d;
  private WriteTogetherEditorView e;
  private EditorController f;
  private ChangesetClient g;
  private IEditorModel w;
  private WriteTogetherOidbObserver x;
  private ChangesetTracker y;
  private UserStateController z;
  
  private void A()
  {
    if (this.b == null)
    {
      this.b = new QQProgressDialog(this.c, 0, 2131627607, 17);
      this.b.setContentView(2131629210);
      this.b.a("正在发送");
      this.b.setCancelable(true);
    }
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
    this.b.show();
    n_(false);
  }
  
  private void B()
  {
    QQProgressDialog localQQProgressDialog = this.b;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.b.dismiss();
    }
    if ((!this.R) && (this.T)) {
      n_(true);
    }
  }
  
  private void C()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((EditorController)localObject).c()))
    {
      localObject = new WriteTogetherEditorFragment.11(this);
      WriteTogetherEditorFragment.12 local12 = new WriteTogetherEditorFragment.12(this);
      WriteTogetherUtils.a(getQBaseActivity(), (DialogInterface.OnClickListener)localObject, local12);
    }
    else
    {
      getQBaseActivity().finish();
      D();
    }
    int i = WriteTogetherUtils.b(this.d, this.B.u);
    if (TextUtils.isEmpty(this.B.f)) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF32", "0X800AF32", i, 0, (String)localObject, "", "", "");
  }
  
  private void D()
  {
    OpenDocParam localOpenDocParam = this.B;
    if ((localOpenDocParam != null) && (WriteTogetherUtils.b(localOpenDocParam.t))) {
      getQBaseActivity().overridePendingTransition(2130772013, 2130772018);
    }
  }
  
  private void E()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.16(this), 100L);
  }
  
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
    localIntent1.putExtra("KEY_WRITE_TOGETHER_GROUPUIN", this.B.u);
    return localIntent1;
  }
  
  private UserEditInfo a(AppRuntime paramAppRuntime, EditText paramEditText)
  {
    UserEditInfo localUserEditInfo = new UserEditInfo();
    localUserEditInfo.a = paramAppRuntime.getAccount();
    localUserEditInfo.e = false;
    localUserEditInfo.f = paramEditText.getSelectionStart();
    localUserEditInfo.g = paramEditText.getSelectionEnd();
    return localUserEditInfo;
  }
  
  public static void a(Activity paramActivity, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle, int paramInt)
  {
    if (P) {
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
      P = true;
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
    if (P) {
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
      P = true;
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
    this.e.setOnEditorClickEventListener(this);
  }
  
  private void a(EditorController paramEditorController, IEditorModel paramIEditorModel, UserEditInfo paramUserEditInfo, List<UserEditInfo> paramList)
  {
    paramUserEditInfo = new CursorManager(paramUserEditInfo, paramList);
    paramIEditorModel.a(paramUserEditInfo);
    paramUserEditInfo.a(paramEditorController);
  }
  
  private void a(OpenDocParam paramOpenDocParam)
  {
    int i = paramOpenDocParam.w;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[doOpenFailed] errno: ");
      localStringBuilder.append(i);
      QLog.d("WriteTogetherEditorFragment", 2, localStringBuilder.toString());
    }
    if (i == 154)
    {
      c(paramOpenDocParam);
      return;
    }
    if (i == 1281)
    {
      q();
      return;
    }
    if (i == 1282)
    {
      q();
      return;
    }
    if (i == 1283)
    {
      this.a.a(EditorState.LIMITED);
      return;
    }
    if (i == 1284)
    {
      q();
      return;
    }
    if (i == 1285)
    {
      a(this.c.getString(2131918134), this.c.getString(2131918145));
      return;
    }
    if (i == 1286)
    {
      q();
      return;
    }
    if (i == 1287)
    {
      a(this.c.getString(2131918144), this.c.getString(2131918142));
      return;
    }
    q();
    paramOpenDocParam = new StringBuilder();
    paramOpenDocParam.append("[doOpenFailed] error code unhandled: ");
    paramOpenDocParam.append(i);
    QLog.e("WriteTogetherEditorFragment", 1, paramOpenDocParam.toString());
  }
  
  private void a(OpenDocParam paramOpenDocParam, int paramInt)
  {
    if (WriteTogetherUtils.b(paramInt))
    {
      this.a.a(EditorState.CREATING);
      return;
    }
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(paramOpenDocParam.f, paramOpenDocParam.u);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.X, 10000L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    WriteTogetherUtils.a(this.c, paramString1, paramString2, new WriteTogetherEditorFragment.4(this));
  }
  
  private void a(boolean paramBoolean, CreateDocParam paramCreateDocParam)
  {
    if (!paramBoolean)
    {
      this.V = false;
      B();
      Resources localResources = this.c.getResources();
      if (paramCreateDocParam.b == 1286)
      {
        WriteTogetherUtils.a(this.c, localResources.getString(2131918137), localResources.getString(2131918145), null);
        n_(false);
        return;
      }
      QQToast.makeText(this.c, localResources.getString(2131918150), 0).show();
    }
  }
  
  private void a(boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (paramBoolean) {
      b(paramOpenDocParam);
    } else {
      a(paramOpenDocParam);
    }
    if (!WriteTogetherConfBean.a(this.d, this.B.u)) {
      this.a.a(EditorState.LIMITED);
    }
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString)
  {
    return ((ITroopGagService)paramAppRuntime.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(paramString, true).b;
  }
  
  private void b(int paramInt)
  {
    if (WriteTogetherUtils.b(paramInt)) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.6(this), 1000L);
    }
  }
  
  private void b(OpenDocParam paramOpenDocParam)
  {
    if (this.N)
    {
      QLog.w("WriteTogetherEditorFragment", 1, "doc is opened already");
      return;
    }
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.X);
    this.f.a(paramOpenDocParam.a, paramOpenDocParam.b, paramOpenDocParam.c);
    String str = this.B.u;
    int i = this.B.t;
    int j = this.B.v;
    this.B = paramOpenDocParam;
    OpenDocParam localOpenDocParam = this.B;
    localOpenDocParam.u = str;
    localOpenDocParam.t = i;
    localOpenDocParam.v = j;
    d(paramOpenDocParam);
    this.z.a(this.B.q);
    this.C = WriteTogetherUtils.b(this.B.l);
    this.w.a(this.C);
    this.w.a(this.B.s);
    WriteTogetherUtils.a(this.B.s);
    if (WriteTogetherUtils.a()) {
      w();
    }
  }
  
  private void c(int paramInt)
  {
    WriteTogetherTemplateConfBean.Template[] arrayOfTemplate = WriteTogetherTemplateConfProcessor.a(this.d, this.B.u);
    if ((arrayOfTemplate != null) && (arrayOfTemplate.length != 0))
    {
      if ((WriteTogetherUtils.b(paramInt)) && (this.A.a() == CreatingState.TEMPLATE_NO))
      {
        if (WriteTogetherUtils.a())
        {
          this.A.a(CreatingState.TEMPLATE_FIRST_USE);
          return;
        }
        if (TextUtils.isEmpty(this.e.getEditorText()))
        {
          this.A.a(CreatingState.TEMPLATE_SHOW_LAYER);
          return;
        }
        this.A.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
      }
    }
    else {
      b(paramInt);
    }
  }
  
  private void c(OpenDocParam paramOpenDocParam)
  {
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(paramOpenDocParam.f, paramOpenDocParam.u);
    if (QLog.isColorLevel())
    {
      paramOpenDocParam = new StringBuilder();
      paramOpenDocParam.append("retry times: ");
      paramOpenDocParam.append(this.D);
      QLog.d("WriteTogetherEditorFragment", 2, paramOpenDocParam.toString());
    }
    this.D += 1;
  }
  
  private void d(OpenDocParam paramOpenDocParam)
  {
    IQQWriteTogetherService localIQQWriteTogetherService = (IQQWriteTogetherService)this.d.getRuntimeService(IQQWriteTogetherService.class, "");
    ChangesetClient localChangesetClient = this.g;
    if (localChangesetClient == null)
    {
      this.g = new ChangesetClient(this.d, this.y, this.B.f, this.B.j, this.B.u);
      this.y.a(this.g);
      this.g.a(new ChangesetScheduler());
      this.g.a(this);
      localIQQWriteTogetherService.addObservers(this);
      localIQQWriteTogetherService.init(paramOpenDocParam.f, paramOpenDocParam.u, paramOpenDocParam.j);
      return;
    }
    localChangesetClient.a(paramOpenDocParam.j);
    localIQQWriteTogetherService.updateRev(paramOpenDocParam.j);
  }
  
  private WriteTogetherOidbObserver p()
  {
    return new WriteTogetherEditorFragment.3(this);
  }
  
  private void q()
  {
    a(this.c.getString(2131918143), this.c.getString(2131918142));
  }
  
  private void r()
  {
    this.E.setVisibility(8);
    if (!WriteTogetherUtils.b(this.B.t)) {
      this.F.setVisibility(0);
    }
    this.e.setVisibility(0);
  }
  
  private void s()
  {
    if ((!TextUtils.isEmpty(this.e.getEditorText())) && (this.T))
    {
      n_(true);
      return;
    }
    n_(false);
  }
  
  private boolean t()
  {
    DocMetaData localDocMetaData = this.C;
    return (localDocMetaData != null) && (!TextUtils.isEmpty(localDocMetaData.a)) && (!this.C.a.equals(this.d.getAccount()));
  }
  
  private boolean u()
  {
    OpenDocParam localOpenDocParam = this.B;
    return (localOpenDocParam != null) && (!TextUtils.isEmpty(localOpenDocParam.f));
  }
  
  private void v()
  {
    this.e.c();
    this.z.e();
    ReportController.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", WriteTogetherUtils.b(this.d, this.B.u), 0, "1", "", this.B.f, "");
  }
  
  private void w()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null)
    {
      WriteTogetherUtils.a(localQBaseActivity, new WriteTogetherEditorFragment.7(this));
      this.z.f();
    }
  }
  
  private void x()
  {
    this.I = ((TextView)m().findViewById(2131447581));
    int i = this.c.getResources().getColor(2131167990);
    this.I.setTextColor(i);
    this.e = ((WriteTogetherEditorView)this.t.findViewById(2131432620));
    i = this.c.getResources().getColor(2131168096);
    this.e.setTextColor(i);
    this.e.setEnabled(false);
    a(this.e);
    b(getResources().getString(2131918128), new WriteTogetherEditorFragment.9(this));
    Object localObject = getArguments();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("KEY_CANCEL_OR_BACK");
      if ((localObject != null) && (((String)localObject).equals("VALUE_CANCEL"))) {
        a(2131918093, new WriteTogetherEditorFragment.10(this));
      }
    }
    this.k.setBackgroundResource(0);
    this.k.requestLayout();
    this.F = ((TextView)this.t.findViewById(2131450314));
    this.E = this.t.findViewById(2131437602);
    this.G = a(HardCodeUtil.a(2131918127), 2131629707);
    this.H = new UserStateBar(this.c, this.G, this.F);
  }
  
  private void y()
  {
    WriteTogetherOidbHandlerImpl localWriteTogetherOidbHandlerImpl = (WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME);
    Object localObject = this.B;
    int j = 0;
    int i;
    if (localObject != null)
    {
      localObject = ((OpenDocParam)localObject).u;
      i = this.B.t;
    }
    else
    {
      localObject = "";
      i = 0;
    }
    TextUtils.isEmpty((CharSequence)localObject);
    if (WriteTogetherUtils.b(i))
    {
      i = 1;
      localWriteTogetherOidbHandlerImpl.createDoc(this.w.e(), (String)localObject);
    }
    else
    {
      DocMetaData localDocMetaData = this.w.g();
      i = j;
      if (localDocMetaData != null)
      {
        TextUtils.isEmpty(localDocMetaData.c);
        localWriteTogetherOidbHandlerImpl.sendWtMessage(localDocMetaData.c, "", 0, (String)localObject);
        i = j;
      }
    }
    j = WriteTogetherUtils.b(this.d, (String)localObject);
    if (i != 0) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF33", "0X800AF33", j, 0, (String)localObject, z(), "", "");
  }
  
  private String z()
  {
    Object localObject = this.B;
    if ((localObject != null) && (WriteTogetherUtils.b(((OpenDocParam)localObject).t)))
    {
      if ((this.A.a() == CreatingState.TEMPLATE_SHOW_ENTRANCE) && (this.A.b() != CreatingState.TEMPLATE_SHOW_LAYER)) {
        return "1000";
      }
      localObject = this.J;
      if ((localObject != null) && (((RecyclerView)localObject).getAdapter() != null)) {
        return String.valueOf(((HorizontalAdapter)this.J.getAdapter()).b());
      }
    }
    return "";
  }
  
  protected int a()
  {
    return 2131627295;
  }
  
  public void a(int paramInt)
  {
    this.z.a(paramInt);
    this.w.b(paramInt);
    if (!this.y.b()) {
      this.f.d();
    }
    if ((this.V) && (!this.y.b())) {
      y();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, paramString);
    this.z.a(paramInt, paramString);
    if (this.V)
    {
      this.V = false;
      B();
      paramString = this.c;
      QQToast.makeText(paramString, paramString.getResources().getString(2131918150), 0).show();
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    x();
    this.f = new EditorController(this.d);
    a(this.f);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      OpenDocParam localOpenDocParam = (OpenDocParam)paramLayoutInflater.get("KEY_LAUNCH_EDITOR_PARAM");
      if (localOpenDocParam != null)
      {
        this.a.a(localOpenDocParam.u);
        this.f.a(localOpenDocParam.t);
        this.B = localOpenDocParam;
        h();
        paramViewGroup = localOpenDocParam.a;
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup == null) {
          paramLayoutInflater = "";
        }
        a(localOpenDocParam, localOpenDocParam.t);
        this.e.b(paramLayoutInflater);
        s();
        paramBundle = new AttribPool();
        if (TextUtils.isEmpty(localOpenDocParam.b)) {
          paramLayoutInflater = Changeset.a(paramLayoutInflater, Arrays.asList(new Pair[] { new Pair("author", this.d.getAccount()) }), paramBundle);
        } else {
          paramLayoutInflater = Changeset.b(paramLayoutInflater, localOpenDocParam.b);
        }
        if (!"0".equals(this.d.getAccount())) {
          paramViewGroup = this.d.getAccount();
        } else {
          paramViewGroup = "";
        }
        this.w = new EditorModel(paramLayoutInflater, paramBundle, paramViewGroup, "");
        this.y = new ChangesetTracker(this.w.d(), this.f);
        this.f.a(this.e);
        this.e.setClient(this.f);
        this.f.a(this.w);
        this.w.a(this.f);
        this.f.a(this.y);
        this.z = new UserStateController(this.d, this.H, this.w, this.B.t, getQBaseActivity());
        this.z.a(this);
        this.z.a(this);
        this.w.a(this.z);
        this.w.a(this.z);
        this.w.a(this.B.u, this.d.getAccount(), "");
        paramLayoutInflater = a(this.d, this.e);
        a(this.f, this.w, paramLayoutInflater, new ArrayList());
        this.W = new WriteTogetherEditorFragment.MyNetInfoHandler(this, null);
        AppNetConnInfo.registerConnectionChangeReceiver(this.d.getApplication(), this.W);
        c(this.B.t);
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
        this.O = false;
        a(paramType.result, paramType.errMsg);
        return;
      }
      this.O = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.U = paramBoolean;
    if ((!paramBoolean) && (this.T))
    {
      if (this.k.isEnabled()) {
        n_(true);
      }
    }
    else {
      n_(false);
    }
  }
  
  public void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((!this.N) && (this.O))
    {
      if (this.S) {
        return;
      }
      this.N = true;
      if (paramBoolean)
      {
        if (((IAnonymousChatApi)QRoute.api(IAnonymousChatApi.class)).getAioAnonymousStatus(this.B.u)) {
          this.a.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131918130));
        } else if (a(this.d, this.B.u)) {
          this.a.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131918140));
        } else {
          this.a.a(EditorState.READY);
        }
      }
      else {
        this.a.a(EditorState.LIMITED);
      }
      this.z.d();
      r();
      if (paramBoolean)
      {
        ChangesetClient localChangesetClient = this.g;
        if (localChangesetClient != null) {
          localChangesetClient.a(((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
        }
      }
      this.w.a(this.B.u, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uid, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      if (!WriteTogetherUtils.a(this.d, this.B.u)) {
        this.a.a(EditorState.CLOSED_BY_ADMIN, getString(2131918131));
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      s();
      return;
    }
    n_(paramBoolean1);
  }
  
  public void b()
  {
    this.z.b();
  }
  
  public void c()
  {
    if (this.B == null)
    {
      QLog.w("WriteTogetherEditorFragment", 1, "refresh failed, param is null");
      return;
    }
    ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).openDoc(this.B.f, this.B.u);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.e.setEnabled(true);
      this.e.setFocusable(true);
      this.e.setCursorVisible(true);
      this.e.requestFocus();
      this.K.setVisibility(8);
      this.M.setVisibility(0);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.e.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this.e, 0);
      }
    }
    else
    {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.17(this), 100L);
      this.K.setVisibility(8);
      this.M.setVisibility(0);
    }
  }
  
  public void d()
  {
    r();
  }
  
  public void e()
  {
    Object localObject = (InputMethodManager)this.e.getContext().getSystemService("input_method");
    if (localObject != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.e.getWindowToken(), 0);
    }
    this.e.setFocusable(false);
    this.e.setCursorVisible(false);
    if (this.J.getAdapter() != null)
    {
      this.J.smoothScrollToPosition(0);
      localObject = (HorizontalAdapter)this.J.getAdapter();
      ((HorizontalAdapter)localObject).a(TextUtils.isEmpty(this.e.getText()) ^ true);
      ((HorizontalAdapter)localObject).a(0);
    }
    this.M.setVisibility(8);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.18(this, (TranslateAnimation)localObject), 100L);
  }
  
  public void f()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
    {
      WriteTogetherUtils.a(localQBaseActivity, new WriteTogetherEditorFragment.15(this));
      this.z.f();
    }
  }
  
  public void g()
  {
    if (this.A.a() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      if (this.J.getAdapter() != null) {
        ReportController.b(null, "dc00898", "", "", "0X800B356", "0X800B356", ((HorizontalAdapter)this.J.getAdapter()).b(), 0, String.valueOf(WriteTogetherUtils.b(this.d, this.B.u)), "", "", "");
      }
      this.A.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
    }
    this.a.a(0);
    UserStateController localUserStateController = this.z;
    if (localUserStateController != null) {
      localUserStateController.e();
    }
    if (this.a.a() == EditorState.READY)
    {
      if (!this.Q) {
        ReportController.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", WriteTogetherUtils.b(this.d, this.B.u), 0, "2", "", this.B.f, "");
      }
      this.Q = true;
      this.a.a(EditorState.ACTIVATED);
      this.f.d();
    }
    this.w.a(true);
  }
  
  public void h()
  {
    this.K = this.t.findViewById(2131437242);
    this.M = this.t.findViewById(2131437243);
    this.L = ((ImageView)this.t.findViewById(2131435480));
    this.L.setOnTouchListener(new WriteTogetherEditorFragment.13(this));
    this.L.setOnClickListener(new WriteTogetherEditorFragment.14(this));
    HorizontalAdapter localHorizontalAdapter = new HorizontalAdapter(getQBaseActivity(), this.e, WriteTogetherUtils.b(this.d, this.B.u));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getQBaseActivity());
    localLinearLayoutManager.setOrientation(0);
    this.J = ((RecyclerView)this.t.findViewById(2131444521));
    this.J.setLayoutManager(localLinearLayoutManager);
    this.J.setAdapter(localHorizontalAdapter);
    localHorizontalAdapter.a(WriteTogetherTemplateConfProcessor.a(this.d, this.B.u));
  }
  
  public boolean onBackEvent()
  {
    C();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.c = getQBaseActivity();
    this.d = ((AppInterface)getQBaseActivity().getAppRuntime());
    this.x = p();
    this.d.addObserver(this.x);
    this.a = new EditorStateMachineController(this.d, getQBaseActivity(), this);
    this.a.a(this);
    this.a.b();
    this.A = new CreatingStateMachineController(this);
    this.A.c();
    paramBundle = getQBaseActivity();
    if ((paramBundle != null) && (paramBundle.getWindow() != null)) {
      paramBundle.getWindow().setSoftInputMode(16);
    }
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = (OpenDocParam)paramBundle.get("KEY_LAUNCH_EDITOR_PARAM");
      if ((paramBundle != null) && (WriteTogetherUtils.b(paramBundle.t))) {
        getQBaseActivity().overridePendingTransition(2130772014, 2130772017);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((u()) && (t()))
    {
      localObject = this.f;
      if ((localObject != null) && (((EditorController)localObject).g()) && (NetworkUtil.isNetworkAvailable())) {
        ((WriteTogetherOidbHandlerImpl)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(WriteTogetherOidbHandlerImpl.CLASS_NAME)).sendGrayTip(this.d.getAccount(), this.B.u, this.B.f);
      }
    }
    this.d.removeObserver(this.x);
    Object localObject = this.f;
    if (localObject != null) {
      ((EditorController)localObject).e();
    }
    this.a.c();
    localObject = this.g;
    if (localObject != null) {
      ((ChangesetClient)localObject).d();
    }
    localObject = this.z;
    if (localObject != null) {
      ((UserStateController)localObject).c();
    }
    localObject = (IQQWriteTogetherService)this.d.getRuntimeService(IQQWriteTogetherService.class, "");
    ((IQQWriteTogetherService)localObject).removeObserver(this);
    ((IQQWriteTogetherService)localObject).stop();
    localObject = this.W;
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
    int i = WriteTogetherUtils.b(this.d, this.B.u);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(WriteTogetherUtils.c(this.B.t));
    String str = ((StringBuilder)localObject).toString();
    if (this.B.f == null) {
      localObject = "";
    } else {
      localObject = this.B.f;
    }
    ReportController.b(null, "dc00898", "", "", "0X800AF30", "0X800AF30", i, 0, str, "", (String)localObject, "");
  }
  
  public void p_(boolean paramBoolean)
  {
    this.f.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorFragment
 * JD-Core Version:    0.7.0.1
 */