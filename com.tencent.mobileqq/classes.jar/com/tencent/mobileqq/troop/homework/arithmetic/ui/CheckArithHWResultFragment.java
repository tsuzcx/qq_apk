package com.tencent.mobileqq.troop.homework.arithmetic.ui;

import airz;
import aisa;
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
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult;
import com.tencent.mobileqq.troop.homework.arithmetic.data.ArithResult.Item;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.SendArithHomeResultSegment.ReqInfo;
import com.tencent.mobileqq.troop.homework.arithmetic.stream.UploadImageSegment;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.SystemBarCompact;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckArithHWResultFragment
  extends PublicBaseFragment
  implements View.OnClickListener, URLDrawable.URLDrawableListener, ArithResultView.OnItemClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ArithResult jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult;
  private ArithResultView jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  Stream jdField_a_of_type_ComTribeAsyncReactiveStream;
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
    AssertUtils.a(paramString1);
    AssertUtils.a(paramString2);
    AssertUtils.a(paramString3);
    AssertUtils.a(paramString4);
    AssertUtils.a(paramString6);
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("json", paramString2);
    localIntent.putExtra("cb", paramString3);
    localIntent.putExtra("troopUin", paramString5);
    localIntent.putExtra("hwId", paramString4);
    localIntent.putExtra("targetUin", paramString6);
    SLog.a("QQ.Troop.homework.CheckArithHWResultFragment", "getOpenIntent %s", localIntent.toString());
    localIntent.setClass(paramActivity, PublicFragmentActivity.class);
    localIntent.putExtra("public_fragment_class", CheckArithHWResultFragment.class.getName());
    return localIntent;
  }
  
  public static JSONObject a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("imgUrl");
    paramIntent = paramIntent.getStringExtra("ytData");
    SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "handleWebCallBack:" + str);
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
      SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "handleWebCallBack--json put data failed imgUrl=:" + str + ",ytDate=" + paramIntent);
    }
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    Intent localIntent = new Intent();
    AssertUtils.a(paramString1);
    AssertUtils.a(paramString2);
    AssertUtils.a(paramString3);
    localIntent.putExtra("magic_code", 15453);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("json", paramString2);
    localIntent.putExtra("cb", paramString3);
    localIntent.putExtra("troopUin", paramString5);
    localIntent.putExtra("hwId", paramString4);
    PublicFragmentActivity.a(paramActivity, localIntent, CheckArithHWResultFragment.class);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.jdField_a_of_type_Boolean)
    {
      a(null, null);
      return;
    }
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    SendArithHomeResultSegment.ReqInfo localReqInfo = new SendArithHomeResultSegment.ReqInfo();
    localReqInfo.jdField_a_of_type_Long = Long.parseLong(this.e);
    localReqInfo.jdField_b_of_type_JavaLangString = paramString;
    localReqInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    try
    {
      localReqInfo.jdField_b_of_type_Long = Long.parseLong(this.jdField_b_of_type_JavaLangString);
      localReqInfo.c = Long.parseLong(this.f);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_ComTribeAsyncReactiveStream = Stream.of(paramBitmap).map(new ThreadOffFunction(2)).map(new UploadImageSegment(this.e, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.jdField_a_of_type_Int)).map(new SendArithHomeResultSegment(localReqInfo)).map(new UIThreadOffFunction(null));
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.subscribe(new aisa(this));
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        AssertUtils.a("requestSendHomeworkResult hwid=" + this.jdField_b_of_type_JavaLangString + "uin=" + this.f + " is illegal", new Object[0]);
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
  
  public void a(Activity paramActivity)
  {
    paramActivity.getWindow().addFlags(1024);
  }
  
  public void a(ArithResult.Item paramItem)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramItem.jdField_a_of_type_JavaLangString.replace("*", "x").replace("/", "÷").replace("frac", "").replace(",", "/"));
    int i = (int)(paramItem.b - paramItem.d * 0.05F);
    int j = (int)(paramItem.c - paramItem.e * 0.05F);
    int k = (int)(paramItem.b + paramItem.d * 1.05F);
    int m = (int)(paramItem.c + paramItem.e * 1.05F);
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
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a = paramItem;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
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
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    try
    {
      a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.a(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.a());
      return true;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        AssertUtils.a("QQ.Troop.homework.CheckArithHWResultFragment//onBackEvent toJSON error:" + localJSONException, new Object[0]);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetImageView) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    while (paramView != this.jdField_c_of_type_AndroidWidgetTextView) {
      return;
    }
    ArithResult.Item localItem = (ArithResult.Item)this.jdField_a_of_type_ComTencentWidgetActionSheet.a;
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.jdField_a_of_type_Boolean = true;
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult;
    paramView.jdField_a_of_type_Int -= 1;
    localItem.jdField_a_of_type_Boolean = true;
    paramView = "全对";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.jdField_a_of_type_Int > 0) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.jdField_a_of_type_Int + "道错题";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "teacher correct the item:" + localItem.toString());
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
      AssertUtils.a(bool, "you must use the function:CheckArithHWResultFragment.open() to open this page!!!! :" + i);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("url");
      this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("json");
      this.d = paramBundle.getStringExtra("cb");
      this.e = paramBundle.getStringExtra("troopUin");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("hwId");
      this.f = paramBundle.getStringExtra("targetUin");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult = ArithResult.a(this.jdField_c_of_type_JavaLangString);
        SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "onCreate");
        return;
        bool = false;
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "json is illegal!! " + this.jdField_c_of_type_JavaLangString);
          QQToast.a(getActivity(), 1, "传入的优图批改数据失效", 0).a();
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = paramLayoutInflater.inflate(2130970599, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getActivity(), null));
    paramLayoutInflater = paramLayoutInflater.inflate(2130970600, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramLayoutInflater);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131371379));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131371383));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131371381));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131371384));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramLayoutInflater = getActivity();
    paramLayoutInflater.getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(0));
    if (paramLayoutInflater.mSystemBarComp == null) {
      paramLayoutInflater.setImmersiveStatus(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView = ((ArithResultView)paramBundle.findViewById(2131371374));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramBundle.findViewById(2131371375));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131371378));
      paramLayoutInflater = "全对";
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.jdField_a_of_type_Int > 0)
      {
        paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.jdField_a_of_type_Int + "道错题";
        label233:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramLayoutInflater);
        ((TextView)paramBundle.findViewById(2131371377)).setOnClickListener(new airz(this));
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
          if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult.a() != 0) {
            break label233;
          }
          paramLayoutInflater = "没有检测到口算题目";
          break label233;
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
        SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "url is illegal!! " + this.jdField_a_of_type_JavaLangString);
        QQToast.a(getActivity(), 1, "传入的图片链接失效", 0).a();
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
    SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "onDestroy");
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTribeAsyncReactiveStream != null) {
      this.jdField_a_of_type_ComTribeAsyncReactiveStream.cancel();
    }
    SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "onDetach");
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "onLoadCanceled url=" + paramURLDrawable.getURL().toString());
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "onLoadFialed url=" + paramURLDrawable.getURL().toString());
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "urlDrawable onLoad Success url:" + paramURLDrawable.getURL().toString());
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
        SLog.d("QQ.Troop.homework.CheckArithHWResultFragment", "region bitmap is null!!");
        localObject2 = ImageUtil.a(paramURLDrawable, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setData(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticDataArithResult);
        if (localObject2 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setImageBitmap((Bitmap)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkArithmeticUiArithResultView.setOnItemClickListener(this);
          return;
        }
        SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "URLDrawable onLoadSuccessed bitmap is null!!");
        return;
      }
      SLog.e("QQ.Troop.homework.CheckArithHWResultFragment", "URLDrawable onLoadSuccessed mArithResultView is null!!");
      return;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment
 * JD-Core Version:    0.7.0.1
 */