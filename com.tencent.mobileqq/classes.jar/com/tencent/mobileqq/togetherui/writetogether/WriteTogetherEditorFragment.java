package com.tencent.mobileqq.togetherui.writetogether;

import adxr;
import amtj;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import aqeg;
import aqej;
import aqel;
import bcef;
import bdef;
import bdej;
import bdev;
import bdge;
import bdgh;
import bdgj;
import bdgl;
import bdgm;
import bdgn;
import bdgr;
import bdgv;
import bdgw;
import bdgz;
import bdhh;
import bdhj;
import bdhk;
import bdhl;
import bdhm;
import bdho;
import bdhq;
import bdht;
import bdhy;
import bdhz;
import bdid;
import bdjp;
import bdjq;
import bdjr;
import bdjx;
import bdkh;
import bdkk;
import bdkl;
import bdkm;
import bdkn;
import bdko;
import bdkp;
import bdkq;
import bdkr;
import bdks;
import bdkt;
import bdku;
import bdkv;
import bdky;
import bhht;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.writetogether.data.OpenDocParam;
import com.tencent.mobileqq.together.writetogether.statemachine.CreatingState;
import com.tencent.mobileqq.together.writetogether.statemachine.EditorState;
import com.tencent.mobileqq.together.writetogether.websocket.msg.BaseWriteTogetherMsg.Type;
import com.tencent.mobileqq.together.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.together.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg;
import com.tencent.mobileqq.together.writetogether.websocket.msg.UserNewInfoMsg.Header;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nmy;

public class WriteTogetherEditorFragment
  extends IphoneTitleBarFragment
  implements bdge, bdgz, bdhj, bdhk, bdjp, bdjq, bdjx, bdky
{
  private static boolean jdField_c_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdev jdField_a_of_type_Bdev;
  private bdgm jdField_a_of_type_Bdgm;
  private bdgr jdField_a_of_type_Bdgr;
  private bdgw jdField_a_of_type_Bdgw;
  private bdhh jdField_a_of_type_Bdhh;
  private bdho jdField_a_of_type_Bdho;
  private bdht jdField_a_of_type_Bdht;
  private bdhz jdField_a_of_type_Bdhz;
  bdid jdField_a_of_type_Bdid;
  private bdkh jdField_a_of_type_Bdkh;
  bhht jdField_a_of_type_Bhht;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private OpenDocParam jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam;
  private WriteTogetherEditorView jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new WriteTogetherEditorFragment.5(this);
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = true;
  private View jdField_c_of_type_AndroidViewView;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i;
  
  private bdgm a()
  {
    return new bdkq(this);
  }
  
  private bdhy a(QQAppInterface paramQQAppInterface, EditText paramEditText)
  {
    bdhy localbdhy = new bdhy();
    localbdhy.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    localbdhy.jdField_a_of_type_Boolean = false;
    localbdhy.c = paramEditText.getSelectionStart();
    localbdhy.d = paramEditText.getSelectionEnd();
    return localbdhy;
  }
  
  private String a()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam != null)
    {
      str1 = str2;
      if (bdgn.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int))
      {
        if ((this.jdField_a_of_type_Bdhz.a() != CreatingState.TEMPLATE_SHOW_ENTRANCE) || (this.jdField_a_of_type_Bdhz.b() == CreatingState.TEMPLATE_SHOW_LAYER)) {
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
    return String.valueOf(((bdjr)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter()).a());
  }
  
  public static void a(Activity paramActivity, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle, int paramInt)
  {
    if (jdField_c_of_type_Boolean) {}
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
      adxr.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass, paramInt);
      jdField_c_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.2(), 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherEditorFragment", 2, "start fragment: " + paramClass.getName());
  }
  
  public static void a(Context paramContext, Class<? extends WriteTogetherEditorFragment> paramClass, Bundle paramBundle)
  {
    if (jdField_c_of_type_Boolean) {}
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
      adxr.a(paramContext, localIntent, PublicFragmentActivity.class, paramClass);
      jdField_c_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.1(), 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("WriteTogetherEditorFragment", 2, "start fragment: " + paramClass.getName());
  }
  
  private void a(bdgw parambdgw)
  {
    parambdgw.a(new bdkt(this));
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setOnEditorClickEventListener(this);
  }
  
  private void a(bdgw parambdgw, bdht parambdht, bdhy parambdhy, List<bdhy> paramList)
  {
    parambdhy = new bdhm(parambdhy, paramList);
    parambdht.a(parambdhy);
    parambdhy.a(parambdgw);
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
      h();
      return;
    }
    if (j == 1282)
    {
      h();
      return;
    }
    if (j == 1283)
    {
      this.jdField_a_of_type_Bdid.a(EditorState.LIMITED);
      return;
    }
    if (j == 1284)
    {
      h();
      return;
    }
    if (j == 1285)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131719702), this.jdField_a_of_type_AndroidContentContext.getString(2131719713));
      return;
    }
    if (j == 1286)
    {
      h();
      return;
    }
    if (j == 1287)
    {
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131719712), this.jdField_a_of_type_AndroidContentContext.getString(2131719710));
      return;
    }
    h();
    QLog.e("WriteTogetherEditorFragment", 1, "[doOpenFailed] error code unhandled: " + j);
  }
  
  private void a(OpenDocParam paramOpenDocParam, int paramInt)
  {
    if (bdgn.a(paramInt))
    {
      this.jdField_a_of_type_Bdid.a(EditorState.CREATING);
      return;
    }
    ((bdgl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(184)).a(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    ThreadManagerV2.getUIHandlerV2().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  private void a(String paramString1, String paramString2)
  {
    bdgn.a(this.jdField_a_of_type_AndroidContentContext, paramString1, paramString2, new bdkr(this));
  }
  
  private void a(boolean paramBoolean, bdhl parambdhl)
  {
    Resources localResources;
    if (!paramBoolean)
    {
      this.i = false;
      p();
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      if (parambdhl.jdField_a_of_type_Int == 1286)
      {
        bdgn.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131719705), localResources.getString(2131719713), null);
        setRightButtonEnable(false);
      }
    }
    else
    {
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, localResources.getString(2131719718), 0).a();
  }
  
  private void a(boolean paramBoolean, OpenDocParam paramOpenDocParam)
  {
    if (paramBoolean) {
      b(paramOpenDocParam);
    }
    for (;;)
    {
      if (!aqeg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        this.jdField_a_of_type_Bdid.a(EditorState.LIMITED);
      }
      return;
      a(paramOpenDocParam);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Bdho != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_Bdho.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bdho.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
  }
  
  private void b(int paramInt)
  {
    if (bdgn.a(paramInt)) {
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
      this.jdField_a_of_type_Bdgw.a(paramOpenDocParam.jdField_a_of_type_JavaLangString, paramOpenDocParam.jdField_b_of_type_JavaLangString, paramOpenDocParam.c);
      String str = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k;
      int j = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int;
      int k = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.g;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam = paramOpenDocParam;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k = str;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int = j;
      this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.g = k;
      d(paramOpenDocParam);
      this.jdField_a_of_type_Bdhh.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Bdho = bdgn.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.i);
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_Bdho);
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.e);
      bdgn.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.e);
    } while (!bdgn.a());
    l();
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam != null) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString));
  }
  
  private void c(int paramInt)
  {
    aqej[] arrayOfaqej = aqel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((arrayOfaqej == null) || (arrayOfaqej.length == 0)) {
      b(paramInt);
    }
    while ((!bdgn.a(paramInt)) || (this.jdField_a_of_type_Bdhz.a() != CreatingState.TEMPLATE_NO)) {
      return;
    }
    if (bdgn.a())
    {
      this.jdField_a_of_type_Bdhz.a(CreatingState.TEMPLATE_FIRST_USE);
      return;
    }
    if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.a()))
    {
      this.jdField_a_of_type_Bdhz.a(CreatingState.TEMPLATE_SHOW_LAYER);
      return;
    }
    this.jdField_a_of_type_Bdhz.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
  }
  
  private void c(OpenDocParam paramOpenDocParam)
  {
    ((bdgl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(184)).a(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k);
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherEditorFragment", 2, "retry times: " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int += 1;
  }
  
  private void d(OpenDocParam paramOpenDocParam)
  {
    bdgj localbdgj = (bdgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377);
    if (this.jdField_a_of_type_Bdgr == null)
    {
      this.jdField_a_of_type_Bdgr = new bdgr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bdev, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
      this.jdField_a_of_type_Bdev.a(this.jdField_a_of_type_Bdgr);
      this.jdField_a_of_type_Bdgr.a(new bdgv());
      this.jdField_a_of_type_Bdgr.a(this);
      localbdgj.a(this);
      localbdgj.a(paramOpenDocParam.jdField_f_of_type_JavaLangString, paramOpenDocParam.k, paramOpenDocParam.jdField_b_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Bdgr.a(paramOpenDocParam.jdField_b_of_type_Int);
    localbdgj.a(paramOpenDocParam.jdField_b_of_type_Int);
  }
  
  private void h()
  {
    a(this.jdField_a_of_type_AndroidContentContext.getString(2131719711), this.jdField_a_of_type_AndroidContentContext.getString(2131719710));
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (!bdgn.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setVisibility(0);
  }
  
  private void j()
  {
    if ((!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.a())) && (this.g))
    {
      setRightButtonEnable(true);
      return;
    }
    setRightButtonEnable(false);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.c();
    this.jdField_a_of_type_Bdhh.e();
    bcef.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k), 0, "1", "", this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
  }
  
  private void l()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      bdgn.a(localFragmentActivity, new bdks(this));
      this.jdField_a_of_type_Bdhh.f();
    }
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)getTitleBarView().findViewById(2131378805));
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167009);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(j);
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView = ((WriteTogetherEditorView)this.mContentView.findViewById(2131366166));
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {}
    for (j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167380);; j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167074))
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setTextColor(j);
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setEnabled(false);
      com.tencent.mobileqq.text.TextUtils.fixTextViewANRForAnd10(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView);
      setRightButtonText(getResources().getString(2131719696), new bdku(this));
      Object localObject = getArguments();
      if (localObject != null)
      {
        localObject = ((Bundle)localObject).getString("KEY_CANCEL_OR_BACK");
        if ((localObject != null) && (((String)localObject).equals("VALUE_CANCEL"))) {
          setLeftButton(2131719668, new bdkk(this));
        }
      }
      this.rightViewText.setBackgroundResource(0);
      this.rightViewText.requestLayout();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131381233));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131370248);
      this.jdField_b_of_type_AndroidViewView = setBottomTitleLayoutIdAndInflateIt(amtj.a(2131719695), 2131563013);
      this.jdField_a_of_type_Bdkh = new bdkh(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetTextView);
      return;
    }
  }
  
  private void n()
  {
    bdgl localbdgl = (bdgl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(184);
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k;
    }
    for (int j = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int;; j = 0)
    {
      int k;
      if ((!android.text.TextUtils.isEmpty(str)) || (bdgn.a(j)))
      {
        localbdgl.a(this.jdField_a_of_type_Bdht.a(), str);
        j = 1;
        k = bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
        if (j == 0) {
          break label161;
        }
      }
      label161:
      for (str = "1";; str = "2")
      {
        bcef.b(null, "dc00898", "", "", "0X800AF33", "0X800AF33", k, 0, str, a(), "", "");
        return;
        bdho localbdho = this.jdField_a_of_type_Bdht.a();
        if (localbdho != null)
        {
          if (android.text.TextUtils.isEmpty(localbdho.jdField_b_of_type_JavaLangString)) {}
          localbdgl.a(localbdho.jdField_b_of_type_JavaLangString, "", 0, str);
        }
        j = 0;
        break;
      }
      str = "";
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Bhht == null)
    {
      this.jdField_a_of_type_Bhht = new bhht(this.jdField_a_of_type_AndroidContentContext, 0, 2131561246, 17);
      this.jdField_a_of_type_Bhht.setContentView(2131562728);
      this.jdField_a_of_type_Bhht.a("正在发送");
      this.jdField_a_of_type_Bhht.setCancelable(true);
    }
    if (this.jdField_a_of_type_Bhht.isShowing()) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
    this.jdField_a_of_type_Bhht.show();
    setRightButtonEnable(false);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
      this.jdField_a_of_type_Bhht.dismiss();
    }
    if ((!this.e) && (this.g)) {
      setRightButtonEnable(true);
    }
  }
  
  private void q()
  {
    int j;
    if ((this.jdField_a_of_type_Bdgw != null) && (this.jdField_a_of_type_Bdgw.b()))
    {
      localObject = new bdkl(this);
      bdkm localbdkm = new bdkm(this);
      bdgn.a(getActivity(), (DialogInterface.OnClickListener)localObject, localbdkm);
      j = bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
      if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)) {
        break label117;
      }
    }
    label117:
    for (Object localObject = "1";; localObject = "2")
    {
      bcef.b(null, "dc00898", "", "", "0X800AF32", "0X800AF32", j, 0, (String)localObject, "", "", "");
      return;
      getActivity().finish();
      r();
      break;
    }
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam != null) && (bdgn.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int))) {
      getActivity().overridePendingTransition(2130771996, 2130772001);
    }
  }
  
  private void s()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.16(this), 100L);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bdhh.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Bdhh.a(paramInt);
    this.jdField_a_of_type_Bdht.b(paramInt);
    if (!this.jdField_a_of_type_Bdev.a()) {
      this.jdField_a_of_type_Bdgw.a();
    }
    if ((this.i) && (!this.jdField_a_of_type_Bdev.a())) {
      n();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Bdid.a(paramInt, paramString);
    this.jdField_a_of_type_Bdhh.a(paramInt, paramString);
    if (this.i)
    {
      this.i = false;
      p();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719718), 0).a();
    }
  }
  
  public void a(BaseWriteTogetherMsg.Type paramType, boolean paramBoolean, Object paramObject)
  {
    if (paramType == BaseWriteTogetherMsg.Type.CLIENT_READY)
    {
      paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
      if ((paramType.result != 0) && (paramType.result != 60009))
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
      if (nmy.a().a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k)) {
        this.jdField_a_of_type_Bdid.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131719698));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdhh.d();
      i();
      if ((paramBoolean) && (this.jdField_a_of_type_Bdgr != null)) {
        this.jdField_a_of_type_Bdgr.a(((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      }
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uid, ((UserNewInfoMsg.Header)paramUserNewInfoMsg.header).uuId);
      if (bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k)) {
        break;
      }
      this.jdField_a_of_type_Bdid.a(EditorState.CLOSED_BY_ADMIN, getString(2131719699));
      return;
      if (bdgh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k))
      {
        this.jdField_a_of_type_Bdid.a(EditorState.GAG_OR_ANONYMOUS_ON_ENTER, getString(2131719708));
      }
      else
      {
        this.jdField_a_of_type_Bdid.a(EditorState.READY);
        continue;
        this.jdField_a_of_type_Bdid.a(EditorState.LIMITED);
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
    setRightButtonEnable(paramBoolean1);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam == null)
    {
      QLog.w("WriteTogetherEditorFragment", 1, "refresh failed, param is null");
      return;
    }
    ((bdgl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(184)).a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bdgw.a(paramBoolean);
  }
  
  public void c()
  {
    i();
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setFocusable(true);
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setCursorVisible(true);
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.requestFocus();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView, 0);
      }
      return;
    }
    ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.17(this), 100L);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void d()
  {
    Object localObject = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.getContext().getSystemService("input_method");
    if (localObject != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.getWindowToken(), 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setFocusable(false);
    this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setCursorVisible(false);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter() != null)
    {
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.smoothScrollToPosition(0);
      localObject = (bdjr)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter();
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.getText())) {
        break label156;
      }
    }
    label156:
    for (boolean bool = true;; bool = false)
    {
      ((bdjr)localObject).a(bool);
      ((bdjr)localObject).a(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new WriteTogetherEditorFragment.18(this, (TranslateAnimation)localObject), 100L);
      return;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    m();
    g();
    this.jdField_a_of_type_Bdgw = new bdgw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a(this.jdField_a_of_type_Bdgw);
    paramLayoutInflater = getArguments();
    if (paramLayoutInflater != null)
    {
      paramBundle = (OpenDocParam)paramLayoutInflater.get("KEY_LAUNCH_EDITOR_PARAM");
      if (paramBundle != null)
      {
        this.jdField_a_of_type_Bdid.a(paramBundle.k);
        this.jdField_a_of_type_Bdgw.a(paramBundle.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam = paramBundle;
        paramViewGroup = paramBundle.jdField_a_of_type_JavaLangString;
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup == null) {
          paramLayoutInflater = "";
        }
        a(paramBundle, paramBundle.jdField_f_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.b(paramLayoutInflater);
        j();
        paramViewGroup = new bdef();
        if (!android.text.TextUtils.isEmpty(paramBundle.jdField_b_of_type_JavaLangString)) {
          break label451;
        }
      }
    }
    label451:
    for (paramLayoutInflater = bdej.a(paramLayoutInflater, Arrays.asList(new Pair[] { new Pair("author", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) }), paramViewGroup);; paramLayoutInflater = bdej.a(paramLayoutInflater, paramBundle.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bdht = new bdhq(paramLayoutInflater, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), "");
      this.jdField_a_of_type_Bdev = new bdev(this.jdField_a_of_type_Bdht.a(), this.jdField_a_of_type_Bdgw);
      this.jdField_a_of_type_Bdgw.a(this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView);
      this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView.setClient(this.jdField_a_of_type_Bdgw);
      this.jdField_a_of_type_Bdgw.a(this.jdField_a_of_type_Bdht);
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_Bdgw);
      this.jdField_a_of_type_Bdgw.a(this.jdField_a_of_type_Bdev);
      this.jdField_a_of_type_Bdhh = new bdhh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bdkh, this.jdField_a_of_type_Bdht, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int, getActivity());
      this.jdField_a_of_type_Bdhh.a(this);
      this.jdField_a_of_type_Bdhh.a(this);
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_Bdhh);
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_Bdhh);
      this.jdField_a_of_type_Bdht.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
      paramLayoutInflater = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView);
      a(this.jdField_a_of_type_Bdgw, this.jdField_a_of_type_Bdht, paramLayoutInflater, new ArrayList());
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bdkv(this, null);
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      c(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int);
      return;
    }
  }
  
  public void e()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      bdgn.a(localFragmentActivity, new bdkp(this));
      this.jdField_a_of_type_Bdhh.f();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Bdhz.a() == CreatingState.TEMPLATE_SHOW_LAYER)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter() != null) {
        bcef.b(null, "dc00898", "", "", "0X800B356", "0X800B356", ((bdjr)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getAdapter()).a(), 0, String.valueOf(bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k)), "", "", "");
      }
      this.jdField_a_of_type_Bdhz.a(CreatingState.TEMPLATE_SHOW_ENTRANCE);
    }
    this.jdField_a_of_type_Bdid.a(0);
    if (this.jdField_a_of_type_Bdhh != null) {
      this.jdField_a_of_type_Bdhh.e();
    }
    if (this.jdField_a_of_type_Bdid.a() == EditorState.READY)
    {
      if (!this.jdField_d_of_type_Boolean) {
        bcef.b(null, "dc00898", "", "", "0X800AF31", "0X800AF31", bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k), 0, "2", "", this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString, "");
      }
      this.jdField_d_of_type_Boolean = true;
      this.jdField_a_of_type_Bdid.a(EditorState.ACTIVATED);
      this.jdField_a_of_type_Bdgw.a();
    }
    this.jdField_a_of_type_Bdht.a(true);
  }
  
  public void g()
  {
    this.jdField_c_of_type_AndroidViewView = this.mContentView.findViewById(2131369980);
    this.jdField_d_of_type_AndroidViewView = this.mContentView.findViewById(2131369981);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131368454));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(new bdkn(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bdko(this));
    bdjr localbdjr = new bdjr(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTogetheruiWritetogetherWriteTogetherEditorView, bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(getActivity());
    localLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mContentView.findViewById(2131376177));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(localLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(localbdjr);
    localbdjr.a(aqel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public int getContentLayoutId()
  {
    return 2131560943;
  }
  
  public boolean onBackEvent()
  {
    q();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_Bdgm = a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Bdgm);
    this.jdField_a_of_type_Bdid = new bdid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this);
    this.jdField_a_of_type_Bdid.a(this);
    this.jdField_a_of_type_Bdid.a();
    this.jdField_a_of_type_Bdhz = new bdhz(this);
    this.jdField_a_of_type_Bdhz.a();
    paramBundle = getActivity();
    if ((paramBundle != null) && (paramBundle.getWindow() != null)) {
      paramBundle.getWindow().setSoftInputMode(16);
    }
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      paramBundle = (OpenDocParam)paramBundle.get("KEY_LAUNCH_EDITOR_PARAM");
      if ((paramBundle != null) && (bdgn.a(paramBundle.jdField_f_of_type_Int))) {
        getActivity().overridePendingTransition(2130771997, 2130772000);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((b()) && (a()) && (this.jdField_a_of_type_Bdgw != null) && (this.jdField_a_of_type_Bdgw.c()) && (NetworkUtil.isNetworkAvailable())) {
      ((bdgl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(184)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Bdgm);
    if (this.jdField_a_of_type_Bdgw != null) {
      this.jdField_a_of_type_Bdgw.b();
    }
    this.jdField_a_of_type_Bdid.b();
    if (this.jdField_a_of_type_Bdgr != null) {
      this.jdField_a_of_type_Bdgr.c();
    }
    if (this.jdField_a_of_type_Bdhh != null) {
      this.jdField_a_of_type_Bdhh.c();
    }
    bdgj localbdgj = (bdgj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(377);
    localbdgj.b(this);
    localbdgj.a();
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
    int j = bdgn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.k);
    String str2 = "" + bdgn.a(this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString == null) {}
    for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqTogetherWritetogetherDataOpenDocParam.jdField_f_of_type_JavaLangString)
    {
      bcef.b(null, "dc00898", "", "", "0X800AF30", "0X800AF30", j, 0, str2, "", str1, "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.togetherui.writetogether.WriteTogetherEditorFragment
 * JD-Core Version:    0.7.0.1
 */