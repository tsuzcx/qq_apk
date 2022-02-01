package com.tencent.mobileqq.together.writetogether.view;

import afez;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import anzj;
import arkn;
import bdll;
import behh;
import beko;
import beks;
import bele;
import bemm;
import bemp;
import bemr;
import bemt;
import bemu;
import bemv;
import bemz;
import bend;
import bene;
import benh;
import benp;
import benr;
import bens;
import bent;
import benu;
import benw;
import beny;
import beob;
import beog;
import beoh;
import bepn;
import bepo;
import bepz;
import beqc;
import beqd;
import beqe;
import beqf;
import beqg;
import beqh;
import beqi;
import beqj;
import beqk;
import beqn;
import bhnv;
import bjbs;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg.Header;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nlj;

public class WriteTogetherEditorFragment
  extends IphoneTitleBarFragment
  implements bemm, benh, benr, bens, bepn, bepo, beqn
{
  private static boolean c;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bele jdField_a_of_type_Bele;
  private bemu jdField_a_of_type_Bemu;
  private bemz jdField_a_of_type_Bemz;
  private bene jdField_a_of_type_Bene;
  private benp jdField_a_of_type_Benp;
  private benw jdField_a_of_type_Benw;
  private beob jdField_a_of_type_Beob;
  beoh jdField_a_of_type_Beoh;
  private bepz jdField_a_of_type_Bepz;
  bjbs jdField_a_of_type_Bjbs;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private OpenDocParam jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam;
  private WriteTogetherEditorView jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WriteTogetherEditorFragment.5(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  
  private bemu a()
  {
    return new beqf(this);
  }
  
  private beog a(QQAppInterface paramQQAppInterface, EditText paramEditText)
  {
    beog localbeog = new beog();
    localbeog.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localbeog.jdField_a_of_type_Boolean = false;
    localbeog.c = paramEditText.getSelectionStart();
    localbeog.d = paramEditText.getSelectionEnd();
    return localbeog;
  }
  
  public static void a(Activity paramActivity, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle, int paramInt)
  {
    if (c) {}
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
      afez.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass, paramInt);
      c = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.2(), 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherEditorFragment", 2, "start fragment: " + paramClass.getName());
  }
  
  public static void a(Context paramContext, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle)
  {
    if (c) {}
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
      afez.a(paramContext, localIntent, PublicFragmentActivity.class, paramClass);
      c = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.1(), 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherEditorFragment", 2, "start fragment: " + paramClass.getName());
  }
  
  private void a(bene parambene)
  {
    parambene.a(new beqi(this));
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.setOnEditorClickEventListener(this);
  }
  
  private void a(bene parambene, beob parambeob, beog parambeog, List<beog> paramList)
  {
    parambeog = new benu(parambeog, paramList);
    parambeob.a(parambeog);
    parambeog.a(parambene);
  }
  
  private void a(OpenDocParam paramOpenDocParam)
  {
    int j = paramOpenDocParam.h;
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "[doOpenFailed] errno: " + j);
    }
    if (j == 154)
    {
      c(paramOpenDocParam);
      return;
    }
    if (j == 1281)
    {
      e();
      return;
    }
    if (j == 1282)
    {
      e();
      return;
    }
    if (j == 1283)
    {
      this.jdField_a_of_type_Beoh.a(EditorState.LIMITED);
      return;
    }
    if (j == 1284)
    {
      e();
      return;
    }
    if (j == 1285)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131719382), this.jdField_a_of_type_AndroidContentContext.getString(2131719392));
      return;
    }
    if (j == 1286)
    {
      e();
      return;
    }
    if (j == 1287)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131719391), this.jdField_a_of_type_AndroidContentContext.getString(2131719389));
      return;
    }
    e();
    QLog.e("WriteTogetherEditorFragment", 1, "[doOpenFailed] error code unhandled: " + j);
  }
  
  private void a(OpenDocParam paramOpenDocParam, int paramInt)
  {
    if (bemv.a(paramInt))
    {
      this.jdField_a_of_type_Beoh.a(EditorState.CREATING);
      return;
    }
    ((bemt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(184)).a(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    bemv.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, new beqg(this));
  }
  
  private void a(boolean paramBoolean, bent parambent)
  {
    Resources localResources;
    if (!paramBoolean)
    {
      this.i = false;
      m();
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (parambent.jdField_a_of_type_Int == 1286)
      {
        bemv.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131719385), localResources.getString(2131719392), null);
        setRightButtonEnable(false);
      }
    }
    else
    {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131719397), 0).a();
  }
  
  private void a(boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (paramBoolean) {
      b(paramOpenDocParam);
    }
    for (;;)
    {
      if (!arkn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.jdField_a_of_type_Beoh.a(EditorState.LIMITED);
      }
      return;
      a(paramOpenDocParam);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Benw != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Benw.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Benw.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
  }
  
  private void b(int paramInt)
  {
    if (bemv.a(paramInt)) {
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.6(this), 1000L);
    }
  }
  
  private void b(OpenDocParam paramOpenDocParam)
  {
    if (this.jdField_a_of_type_Boolean) {
      QLog.w("WriteTogetherEditorFragment", 1, "doc is opened already");
    }
    do
    {
      return;
      ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_Bene.a(paramOpenDocParam.jdField_a_of_type_JavaLangString, paramOpenDocParam.jdField_b_of_type_JavaLangString, paramOpenDocParam.c);
      String str = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k;
      int j = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int;
      int k = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.g;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam = paramOpenDocParam;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k = str;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int = j;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.g = k;
      d(paramOpenDocParam);
      this.jdField_a_of_type_Benp.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Benw = bemv.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.i);
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_Benw);
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.e);
      bemv.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.e);
    } while (!bemv.a());
    i();
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString));
  }
  
  private void c(OpenDocParam paramOpenDocParam)
  {
    ((bemt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(184)).a(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "retry times: " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  private void d(OpenDocParam paramOpenDocParam)
  {
    bemr localbemr = (bemr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377);
    if (this.jdField_a_of_type_Bemz == null)
    {
      this.jdField_a_of_type_Bemz = new bemz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bele, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
      this.jdField_a_of_type_Bele.a(this.jdField_a_of_type_Bemz);
      this.jdField_a_of_type_Bemz.a(new bend());
      this.jdField_a_of_type_Bemz.a(this);
      localbemr.a(this);
      localbemr.a(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k, paramOpenDocParam.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Bemz.a(paramOpenDocParam.jdField_b_of_type_Int);
    localbemr.a(paramOpenDocParam.jdField_b_of_type_Int);
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131719390), this.jdField_a_of_type_AndroidContentContext.getString(2131719389));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bemv.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.setVisibility(0);
  }
  
  private void g()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.a())) && (this.g))
    {
      setRightButtonEnable(true);
      return;
    }
    setRightButtonEnable(false);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.c();
    this.jdField_a_of_type_Benp.e();
    bdll.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", bemv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k), 0, "1", "", this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
  }
  
  private void i()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      bemv.a(localFragmentActivity, new beqh(this));
      this.jdField_a_of_type_Benp.f();
    }
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)getTitleBarView().findViewById(2131379036));
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166987);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(j);
    this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView = ((WriteTogetherEditorView)this.mContentView.findViewById(2131366137));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {}
    for (j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167345);; j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167052))
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.setTextColor(j);
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.setEnabled(false);
      behh.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView);
      setRightButtonText(getResources().getString(2131719377), new beqj(this));
      Object localObject = getArguments();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("KEY_CANCEL_OR_BACK");
        if ((localObject != null) && (((String)localObject).equals("VALUE_CANCEL"))) {
          setLeftButton(2131719350, new beqc(this));
        }
      }
      this.rightViewText.setBackgroundResource(0);
      this.rightViewText.requestLayout();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131381516));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131370280);
      this.jdField_b_of_type_AndroidViewView = setBottomTitleLayoutIdAndInflateIt(anzj.a(2131719376), 2131563128);
      this.jdField_a_of_type_Bepz = new bepz(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void k()
  {
    bemt localbemt = (bemt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(184);
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k;
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int;; j = 0)
    {
      int k;
      if ((!TextUtils.isEmpty(str)) || (bemv.a(j)))
      {
        localbemt.a(this.jdField_a_of_type_Beob.a(), str);
        j = 1;
        k = bemv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
        if (j == 0) {
          break label165;
        }
      }
      label165:
      for (str = "1";; str = "2")
      {
        bdll.b(null, "dc00898", "", "", "0X800AF33", "0X800AF33", k, 0, str, "", "", "");
        return;
        benw localbenw = this.jdField_a_of_type_Beob.a();
        if (localbenw != null)
        {
          if (TextUtils.isEmpty(localbenw.jdField_b_of_type_JavaLangString)) {}
          localbemt.a(localbenw.jdField_b_of_type_JavaLangString, "", 0, str);
        }
        j = 0;
        break;
      }
      str = "";
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this.jdField_a_of_type_AndroidContentContext, 0, 2131561371, 17);
      this.jdField_a_of_type_Bjbs.setContentView(2131562849);
      this.jdField_a_of_type_Bjbs.a("正在发送");
      this.jdField_a_of_type_Bjbs.setCancelable(true);
    }
    if (this.jdField_a_of_type_Bjbs.isShowing()) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    this.jdField_a_of_type_Bjbs.show();
    setRightButtonEnable(false);
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    if ((!this.e) && (this.g)) {
      setRightButtonEnable(true);
    }
  }
  
  private void n()
  {
    int j;
    if ((this.jdField_a_of_type_Bene != null) && (this.jdField_a_of_type_Bene.b()))
    {
      localObject = new beqd(this);
      beqe localbeqe = new beqe(this);
      bemv.a(getActivity(), (DialogInterface.OnClickListener)localObject, localbeqe);
      j = bemv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)) {
        break label113;
      }
    }
    label113:
    for (Object localObject = "1";; localObject = "2")
    {
      bdll.b(null, "dc00898", "", "", "0X800AF32", "0X800AF32", j, 0, (String)localObject, "", "", "");
      return;
      getActivity().finish();
      break;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Benp.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Benp.a(paramInt);
    this.jdField_a_of_type_Beob.b(paramInt);
    if (!this.jdField_a_of_type_Bele.a()) {
      this.jdField_a_of_type_Bene.a();
    }
    if ((this.i) && (!this.jdField_a_of_type_Bele.a())) {
      k();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Beoh.a(paramInt, paramString);
    this.jdField_a_of_type_Benp.a(paramInt, paramString);
    if (this.i)
    {
      this.i = false;
      m();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719397), 0).a();
    }
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    if (paramType == BaseWriteTogetherMsg.Type.CLIENT_READY)
    {
      paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
      if (paramType.result != 0)
      {
        this.jdField_b_of_type_Boolean = false;
        a(paramType.result, paramType.errMsg);
      }
    }
    else
    {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if ((paramBoolean) || (!this.g)) {
      setRightButtonEnable(false);
    }
    while (!this.rightViewText.isEnabled()) {
      return;
    }
    setRightButtonEnable(true);
  }
  
  public void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((this.jdField_a_of_type_Boolean) || (!this.jdField_b_of_type_Boolean) || (this.f)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (paramBoolean) {
      if (nlj.a().a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k)) {
        this.jdField_a_of_type_Beoh.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131719379));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Benp.d();
      f();
      if ((paramBoolean) && (this.jdField_a_of_type_Bemz != null)) {
        this.jdField_a_of_type_Bemz.a(((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      }
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uid, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      if (bemv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k)) {
        break;
      }
      this.jdField_a_of_type_Beoh.a(EditorState.CLOSED_BY_ADMIN, getString(2131719380));
      return;
      if (bemp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k))
      {
        this.jdField_a_of_type_Beoh.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131719387));
      }
      else
      {
        this.jdField_a_of_type_Beoh.a(EditorState.READY);
        continue;
        this.jdField_a_of_type_Beoh.a(EditorState.LIMITED);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      g();
      return;
    }
    setRightButtonEnable(paramBoolean1);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam == null)
    {
      QLog.w("WriteTogetherEditorFragment", 1, "refresh failed, param is null");
      return;
    }
    ((bemt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(184)).a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bene.a(paramBoolean);
  }
  
  public void c()
  {
    f();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Beoh.a(0);
    if (this.jdField_a_of_type_Benp != null) {
      this.jdField_a_of_type_Benp.e();
    }
    if (this.jdField_a_of_type_Beoh.a() == EditorState.READY)
    {
      if (!this.d) {
        bdll.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", bemv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k), 0, "2", "", this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
      }
      this.d = true;
      this.jdField_a_of_type_Beoh.a(EditorState.ACTIVATED);
      this.jdField_a_of_type_Bene.a();
    }
    this.jdField_a_of_type_Beob.a(true);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    j();
    this.jdField_a_of_type_Bene = new bene(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.jdField_a_of_type_Bene);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      paramBundle = (OpenDocParam)paramLayoutInflater.get("KEY_LAUNCH_EDITOR_PARAM");
      if (paramBundle != null)
      {
        this.jdField_a_of_type_Beoh.a(paramBundle.k);
        this.jdField_a_of_type_Bene.a(paramBundle.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam = paramBundle;
        paramViewGroup = paramBundle.jdField_a_of_type_JavaLangString;
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup == null) {
          paramLayoutInflater = "";
        }
        a(paramBundle, paramBundle.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.b(paramLayoutInflater);
        g();
        paramViewGroup = new beko();
        if (!TextUtils.isEmpty(paramBundle.jdField_b_of_type_JavaLangString)) {
          break label447;
        }
      }
    }
    label447:
    for (paramLayoutInflater = beks.a(paramLayoutInflater, Arrays.asList(new Pair[] { new Pair("author", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) }), paramViewGroup);; paramLayoutInflater = beks.a(paramLayoutInflater, paramBundle.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Beob = new beny(paramLayoutInflater, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "");
      this.jdField_a_of_type_Bele = new bele(this.jdField_a_of_type_Beob.a(), this.jdField_a_of_type_Bene);
      this.jdField_a_of_type_Bene.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView);
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView.setClient(this.jdField_a_of_type_Bene);
      this.jdField_a_of_type_Bene.a(this.jdField_a_of_type_Beob);
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_Bene);
      this.jdField_a_of_type_Bene.a(this.jdField_a_of_type_Bele);
      this.jdField_a_of_type_Benp = new benp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bepz, this.jdField_a_of_type_Beob, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int, getActivity());
      this.jdField_a_of_type_Benp.a(this);
      this.jdField_a_of_type_Benp.a(this);
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_Benp);
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_Benp);
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      paramLayoutInflater = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherViewWriteTogetherEditorView);
      a(this.jdField_a_of_type_Bene, this.jdField_a_of_type_Beob, paramLayoutInflater, new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new beqk(this, null);
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      b(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int);
      return;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131563127;
  }
  
  public boolean onBackEvent()
  {
    n();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_Bemu = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bemu);
    this.jdField_a_of_type_Beoh = new beoh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this);
    this.jdField_a_of_type_Beoh.a(this);
    this.jdField_a_of_type_Beoh.a();
    paramBundle = getActivity();
    if ((paramBundle != null) && (paramBundle.getWindow() != null)) {
      paramBundle.getWindow().setSoftInputMode(16);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((b()) && (a()) && (this.jdField_a_of_type_Bene != null) && (this.jdField_a_of_type_Bene.c()) && (bhnv.a())) {
      ((bemt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(184)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bemu);
    if (this.jdField_a_of_type_Bene != null) {
      this.jdField_a_of_type_Bene.b();
    }
    this.jdField_a_of_type_Beoh.b();
    if (this.jdField_a_of_type_Bemz != null) {
      this.jdField_a_of_type_Bemz.c();
    }
    if (this.jdField_a_of_type_Benp != null) {
      this.jdField_a_of_type_Benp.c();
    }
    bemr localbemr = (bemr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377);
    localbemr.b(this);
    localbemr.a();
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
    int j = bemv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
    String str2 = "" + bemv.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString == null) {}
    for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)
    {
      bdll.b(null, "dc00898", "", "", "0X800AF30", "0X800AF30", j, 0, str2, "", str1, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.writetogether.view.WriteTogetherEditorFragment
 * JD-Core Version:    0.7.0.1
 */