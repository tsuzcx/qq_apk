package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import alud;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bbyk;
import bbyl;
import bbyn;
import bbyp;
import bbyr;
import bbys;
import bbyt;
import bbyx;
import bbyy;
import bdhj;
import bhuf;
import bhus;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import wxe;
import xqq;

public class CheckArithHWResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener, bbyt, URLDrawable.URLDrawableListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbyk jdField_a_of_type_Bbyk;
  private bhuf jdField_a_of_type_Bhuf;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ArithResultView jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView;
  Stream<bbyr> jdField_a_of_type_ComTribeAsyncReactiveStream;
  private String jdField_a_of_type_JavaLangString;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  private String f;
  
  public static Intent a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    Intent localIntent = new Intent();
    a(paramString1);
    a(paramString2);
    a(paramString3);
    a(paramString5);
    a(paramString4);
    a(paramString6);
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("json", paramString2);
    localIntent.putExtra("cb", paramString3);
    localIntent.putExtra("troopUin", paramString5);
    localIntent.putExtra("hwId", paramString4);
    localIntent.putExtra("targetUin", paramString6);
    wxe.a("QQ.Troop.homework.CheckArithHWResultFragment", "getOpenIntent %s", localIntent.toString());
    localIntent.setClass(paramActivity, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", CheckArithHWResultFragment.class.getName());
    return localIntent;
  }
  
  public static JSONObject a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("imgUrl");
    paramIntent = paramIntent.getStringExtra("ytData");
    wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "handleWebCallBack:" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("imgUrl", str);
      localJSONObject.put("ytData", paramIntent);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "handleWebCallBack--json put data failed imgUrl=:" + str + ",ytDate=" + paramIntent);
    }
    return localJSONObject;
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.equals("null"))) {
      xqq.a("param is n-u-l-l,plz dont do this...", new Object[0]);
    }
    xqq.a(paramString);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Bbyk.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    bbyp localbbyp = new bbyp();
    localbbyp.jdField_a_of_type_Long = Long.parseLong(this.e);
    localbbyp.jdField_b_of_type_JavaLangString = paramString;
    localbbyp.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    try
    {
      localbbyp.jdField_b_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      localbbyp.c = Long.parseLong(this.f);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(paramBitmap).map(new ThreadOffFunction("QQ.Troop.homework.CheckArithHWResultFragment", 2)).map(new bbys(this.e, this.jdField_a_of_type_Bbyk, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.jdField_a_of_type_Int)).map(new bbyn(localbbyp)).map(new UIThreadOffFunction(null));
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new bbyy(this));
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        xqq.a("requestSendHomeworkResult hwid=" + this.jdField_b_of_type_JavaLangString + "uin=" + this.f + " is illegal", new Object[0]);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("imgUrl", paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("ytData", paramString2);
    }
    getActivity().setResult(0, localIntent);
    getActivity().finish();
  }
  
  public void a(bbyl parambbyl)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(parambbyl.jdField_a_of_type_JavaLangString.replace("*", "x").replace("/", "÷").replace("frac", "").replace(",", "/"));
    int i = (int)(parambbyl.b - parambbyl.d * 0.05F);
    int j = (int)(parambbyl.c - parambbyl.e * 0.05F);
    int k = (int)(parambbyl.b + parambbyl.d * 1.05F);
    int m = (int)(parambbyl.c + parambbyl.e * 1.05F);
    if (i > 0)
    {
      if (j <= 0) {
        break label231;
      }
      label125:
      if (k <= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a().getWidth()) {
        break label236;
      }
      k = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a().getWidth() - i;
      label154:
      if (m <= this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a().getHeight()) {
        break label245;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a().getHeight() - j;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a(), i, j, k, m);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      this.jdField_a_of_type_Bhuf.a = parambbyl;
      this.jdField_a_of_type_Bhuf.show();
      return;
      i = 0;
      break;
      label231:
      j = 0;
      break label125;
      label236:
      k -= i;
      break label154;
      label245:
      m -= j;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    try
    {
      a(this.jdField_a_of_type_Bbyk.a(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a());
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        xqq.a("QQ.Troop.homework.CheckArithHWResultFragment//onBackEvent toJSON error:" + localJSONException, new Object[0]);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      this.jdField_a_of_type_Bhuf.dismiss();
    }
    while (paramView != this.jdField_c_of_type_AndroidWidgetTextView) {
      return;
    }
    bbyl localbbyl = (bbyl)this.jdField_a_of_type_Bhuf.a;
    this.jdField_a_of_type_Bbyk.jdField_a_of_type_Boolean = true;
    paramView = this.jdField_a_of_type_Bbyk;
    paramView.jdField_a_of_type_Int -= 1;
    localbbyl.jdField_a_of_type_Boolean = true;
    paramView = alud.a(2131702155);
    if (this.jdField_a_of_type_Bbyk.jdField_a_of_type_Int > 0) {
      paramView = this.jdField_a_of_type_Bbyk.jdField_a_of_type_Int + alud.a(2131702152);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    this.jdField_a_of_type_Bhuf.dismiss();
    wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "teacher correct the item:" + localbbyl.toString());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent();
    int i = paramBundle.getIntExtra("magic_code", 0);
    boolean bool;
    if (i == 15453) {
      bool = true;
    }
    for (;;)
    {
      xqq.a(bool, "you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :" + i);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("url");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("json");
      this.d = paramBundle.getStringExtra("cb");
      this.e = paramBundle.getStringExtra("troopUin");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("hwId");
      this.f = paramBundle.getStringExtra("targetUin");
      try
      {
        this.jdField_a_of_type_Bbyk = bbyk.a(this.jdField_c_of_type_JavaLangString);
        wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "onCreate");
        return;
        bool = false;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "json is illegal!! " + this.jdField_c_of_type_JavaLangString);
          QQToast.a(getActivity(), 1, alud.a(2131702154), 0).a();
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(2131561344, paramViewGroup, false);
    this.jdField_a_of_type_Bhuf = ((bhuf)bhus.a(getActivity(), null));
    paramLayoutInflater = paramLayoutInflater.inflate(2131561345, paramViewGroup, false);
    this.jdField_a_of_type_Bhuf.a(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131373621));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131373624));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131373623));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131373622));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramLayoutInflater = getActivity();
    paramLayoutInflater.getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(0));
    if (paramLayoutInflater.mSystemBarComp == null) {
      paramLayoutInflater.setImmersiveStatus(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView = ((ArithResultView)paramBundle.findViewById(2131373628));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131373626));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131373630));
      paramLayoutInflater = alud.a(2131702156);
      if (this.jdField_a_of_type_Bbyk.jdField_a_of_type_Int > 0)
      {
        paramLayoutInflater = this.jdField_a_of_type_Bbyk.jdField_a_of_type_Int + alud.a(2131702151);
        label239:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramLayoutInflater);
        ((TextView)paramBundle.findViewById(2131373629)).setOnClickListener(new bbyx(this));
        paramLayoutInflater = URLDrawable.URLDrawableOptions.obtain();
        paramLayoutInflater.mRequestWidth = 0;
        paramLayoutInflater.mRequestHeight = 0;
      }
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(new URL(this.jdField_a_of_type_JavaLangString), paramLayoutInflater);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setAutoDownload(true);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
        {
          onLoadSuccessed(this.jdField_a_of_type_ComTencentImageURLDrawable);
          return paramBundle;
          paramLayoutInflater.mSystemBarComp.setStatusBarDrawable(null);
          paramLayoutInflater.mSystemBarComp.setStatusBarColor(0);
          paramLayoutInflater.mSystemBarComp.setStatusColor(0);
          continue;
          if (this.jdField_a_of_type_Bbyk.a() != 0) {
            break label239;
          }
          paramLayoutInflater = alud.a(2131702153);
          break label239;
        }
        else if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2) || (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 3))
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
          return paramBundle;
        }
      }
      catch (MalformedURLException paramLayoutInflater)
      {
        paramLayoutInflater.printStackTrace();
        wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "url is illegal!! " + this.jdField_a_of_type_JavaLangString);
        QQToast.a(getActivity(), 1, alud.a(2131702150), 0).a();
        return paramBundle;
      }
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
    return paramBundle;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "onDestroy");
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "onDetach");
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "onLoadCanceled url=" + paramURLDrawable.getURL().toString());
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "onLoadFialed url=" + paramURLDrawable.getURL().toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "urlDrawable onLoad Success url:" + paramURLDrawable.getURL().toString());
    Object localObject1 = paramURLDrawable.getCurrDrawable();
    if ((localObject1 instanceof RegionDrawable))
    {
      localObject1 = ((RegionDrawable)localObject1).getBitmap();
      if (localObject1 == null) {}
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        wxe.d("QQ.Troop.homework.CheckArithHWResultFragment", "region bitmap is null!!");
        localObject2 = bdhj.a(paramURLDrawable, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setData(this.jdField_a_of_type_Bbyk);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setImageBitmap((Bitmap)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setOnItemClickListener(this);
          return;
        }
        wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "URLDrawable onLoadSuccessed bitmap is null!!");
        return;
      }
      wxe.e("QQ.Troop.homework.CheckArithHWResultFragment", "URLDrawable onLoadSuccessed mArithResultView is null!!");
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment
 * JD-Core Version:    0.7.0.1
 */