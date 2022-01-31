package com.tencent.mobileqq.conditionsearch;

import SummaryCard.CondFitUser;
import ajfw;
import ajgc;
import ajjj;
import ajjy;
import alxc;
import alxd;
import alxe;
import alxf;
import alxg;
import alxh;
import alxi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import avck;
import avev;
import awqx;
import azwg;
import azwh;
import bacc;
import bacm;
import badq;
import befq;
import begh;
import belq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.InterestLabelTextView;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchResultActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, azwh, begh
{
  public static final boolean a;
  private static List<CondFitUser> b;
  public int a;
  private long jdField_a_of_type_Long;
  ajfw jdField_a_of_type_Ajfw;
  ajgc jdField_a_of_type_Ajgc = new alxe(this);
  public alxg a;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new alxc(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  avck jdField_a_of_type_Avck = new alxf(this);
  avev jdField_a_of_type_Avev;
  azwg jdField_a_of_type_Azwg;
  private belq jdField_a_of_type_Belq = new alxd(this);
  private PullRefreshHeader jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
  public XListView a;
  public List<CondFitUser> a;
  Set<Long> jdField_a_of_type_JavaUtilSet;
  public int b;
  private int c;
  
  static
  {
    jdField_a_of_type_Boolean = AppSetting.c;
  }
  
  public SearchResultActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131494194, this.jdField_a_of_type_ComTencentWidgetXListView, false));
      Drawable localDrawable = getResources().getDrawable(2130839107);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setHeaderBgDrawable(localDrawable);
    }
  }
  
  private void a(alxh paramalxh, RichStatus paramRichStatus)
  {
    paramalxh.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
    if ((paramRichStatus != null) && (!paramRichStatus.isEmpty()))
    {
      if (!TextUtils.isEmpty(paramRichStatus.actionText))
      {
        paramalxh.jdField_a_of_type_Int = paramRichStatus.actionId;
        Object localObject = this.jdField_a_of_type_Avev.a(paramRichStatus.actionId, 200);
        localObject = new BitmapDrawable(getResources(), (Bitmap)localObject);
        int i = this.c;
        ((Drawable)localObject).setBounds(0, 0, Math.round(((Drawable)localObject).getIntrinsicWidth() * 1.0F / ((Drawable)localObject).getIntrinsicHeight() * i), i);
        paramalxh.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
      }
      for (;;)
      {
        paramalxh.jdField_b_of_type_AndroidWidgetTextView.setText(paramRichStatus.toSpannableString(""));
        return;
        paramalxh.jdField_a_of_type_Int = 0;
        paramalxh.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    paramalxh.jdField_a_of_type_Int = 0;
    paramalxh.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramalxh.jdField_b_of_type_AndroidWidgetTextView.setText("");
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt4, int paramInt5, List<CondFitUser> paramList, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, SearchResultActivity.class);
    localIntent.putExtra("key_keyword", paramString);
    localIntent.putExtra("key_age_index1", paramInt1);
    localIntent.putExtra("key_age_index2", paramInt2);
    localIntent.putExtra("key_sex_index", paramInt3);
    localIntent.putExtra("key_loc_code", paramArrayOfString1);
    localIntent.putExtra("key_home_code", paramArrayOfString2);
    localIntent.putExtra("key_xingzuo_index", paramInt5);
    localIntent.putExtra("key_job_index", paramInt4);
    localIntent.putExtra("key_has_more", paramBoolean);
    jdField_b_of_type_JavaUtilList = paramList;
    paramContext.startActivity(localIntent);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131167544));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Belq);
    }
  }
  
  private void c()
  {
    Object localObject = (ViewGroup)findViewById(2131309578);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131309690);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131302804);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Ajgc);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("key_keyword");
    int i = localIntent.getIntExtra("key_age_index1", 0);
    int j = localIntent.getIntExtra("key_age_index2", 0);
    int k = localIntent.getIntExtra("key_sex_index", 0);
    String[] arrayOfString1 = localIntent.getStringArrayExtra("key_loc_code");
    String[] arrayOfString2 = localIntent.getStringArrayExtra("key_home_code");
    int m = localIntent.getIntExtra("key_xingzuo_index", 0);
    int n = localIntent.getIntExtra("key_job_index", 0);
    this.jdField_a_of_type_Ajfw.a(true, str, k, i, j, arrayOfString1, arrayOfString2, n, m, 2);
  }
  
  private void e()
  {
    if (!badq.d(this))
    {
      this.jdField_b_of_type_Int = 4;
      this.jdField_a_of_type_Alxg.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Ajfw.c(this.jdField_a_of_type_Ajgc);
    try
    {
      this.jdField_a_of_type_Ajfw.a(false, null, 0, 0, 0, null, null, 0, 0, 3);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, localException, new Object[0]);
      }
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Alxg.notifyDataSetChanged();
    }
  }
  
  public String a(alxh paramalxh, CondFitUser paramCondFitUser)
  {
    int j = -15550475;
    StringBuilder localStringBuilder = new StringBuilder();
    paramalxh.jdField_a_of_type_JavaLangString = (paramCondFitUser.lUIN + "");
    paramalxh.jdField_a_of_type_AndroidWidgetTextView.setText(paramCondFitUser.strNick);
    localStringBuilder.append(paramCondFitUser.strNick);
    Object localObject2 = this.jdField_a_of_type_Ajfw.a(paramCondFitUser.locDesc)[1];
    Object localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = "";
    }
    String[] arrayOfString = this.jdField_a_of_type_Ajfw.a((String)localObject1);
    localObject2 = arrayOfString[1];
    localObject1 = localObject2;
    if (((String)localObject2).equals("不限")) {
      localObject1 = arrayOfString[0];
    }
    localObject2 = localObject1;
    if (((String)localObject1).equals("不限")) {
      localObject2 = "";
    }
    localObject1 = "";
    int i;
    switch (paramCondFitUser.cSex)
    {
    default: 
      i = 0;
      localStringBuilder.append((String)localObject1).append(String.format("%s岁", new Object[] { Long.valueOf(paramCondFitUser.dwAge) })).append((String)localObject2);
      if (i == 0)
      {
        paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
        paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(paramCondFitUser.dwAge + "");
        label272:
        if (QLog.isColorLevel()) {
          QLog.i("SearchResultActivity", 2, "bindView jobId=" + paramCondFitUser.iOccupationId);
        }
        if ((paramCondFitUser.iOccupationId <= 0) || (paramCondFitUser.iOccupationId >= ajfw.e.length - 1)) {
          break label870;
        }
        paramalxh.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(ajfw.e[paramCondFitUser.iOccupationId]);
        paramalxh.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(ajfw.b[paramCondFitUser.iOccupationId]);
        paramalxh.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
        localStringBuilder.append(ajfw.e[paramCondFitUser.iOccupationId]);
        label380:
        if ((paramCondFitUser.cConstellationId <= 0) || (paramCondFitUser.cConstellationId >= ajfw.c.length)) {
          break label882;
        }
        paramalxh.c.setText(ajfw.c[paramCondFitUser.cConstellationId]);
        paramalxh.c.setColorFormat(-6065741);
        paramalxh.c.setVisibility(0);
        localStringBuilder.append(ajfw.c[paramCondFitUser.cConstellationId]);
        label445:
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label894;
        }
        paramalxh.d.setVisibility(0);
        paramalxh.d.setText((CharSequence)localObject2);
        paramalxh.d.setColorFormat(-8291118);
      }
      break;
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_Azwg.a(1, paramalxh.jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = bacm.a();
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_Azwg.a())
        {
          this.jdField_a_of_type_Azwg.a(paramalxh.jdField_a_of_type_JavaLangString, 1, true, (byte)1);
          localObject1 = localObject2;
        }
      }
      paramalxh.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      a(paramalxh, paramCondFitUser.richStatus);
      localStringBuilder.append(paramalxh.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      localObject1 = new StringBuilder("bindview | uin:");
      ((StringBuilder)localObject1).append(paramCondFitUser.lUIN);
      ((StringBuilder)localObject1).append("| nickname:").append(paramCondFitUser.strNick);
      ((StringBuilder)localObject1).append("| sex:").append(paramCondFitUser.cSex);
      ((StringBuilder)localObject1).append("| age:").append(paramCondFitUser.dwAge);
      ((StringBuilder)localObject1).append("| country:").append(paramCondFitUser.dwCountry);
      ((StringBuilder)localObject1).append("| province:").append(paramCondFitUser.dwProvince);
      ((StringBuilder)localObject1).append("| city:").append(paramCondFitUser.dwCity);
      ((StringBuilder)localObject1).append("| occupation:").append(paramCondFitUser.iOccupationId);
      ((StringBuilder)localObject1).append("| horoscope:").append(paramCondFitUser.cConstellationId);
      ((StringBuilder)localObject1).append("| sign:").append(paramalxh.jdField_b_of_type_AndroidWidgetTextView.getText().toString());
      if (QLog.isColorLevel()) {
        QLog.d("SearchResultActivity", 2, ((StringBuilder)localObject1).toString());
      }
      return localStringBuilder.toString();
      i = 2130840116;
      localObject1 = ajjy.a(2131647851);
      break;
      i = 2130840115;
      j = -38511;
      localObject1 = ajjy.a(2131647870);
      break;
      paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setColorFormat(j);
      paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(0);
      paramalxh.jdField_b_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setText(paramCondFitUser.dwAge + "");
      break label272;
      label870:
      paramalxh.jdField_a_of_type_ComTencentMobileqqWidgetInterestLabelTextView.setVisibility(8);
      break label380;
      label882:
      paramalxh.c.setVisibility(8);
      break label445;
      label894:
      paramalxh.d.setVisibility(8);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131495118);
    setContentBackgroundResource(2130838503);
    setTitle(2131625457);
    setLeftViewName(2131625011);
    c();
    this.jdField_a_of_type_AndroidOsHandler = new befq(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (getIntent().getBooleanExtra("key_has_more", false)) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_JavaUtilList = jdField_b_of_type_JavaUtilList;
      jdField_b_of_type_JavaUtilList = null;
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
        break;
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_Avev = ((avev)this.app.getManager(15));
    if (this.jdField_a_of_type_Avev != null) {
      this.jdField_a_of_type_Avev.a(this.jdField_a_of_type_Avck);
    }
    this.jdField_a_of_type_Ajfw = ((ajfw)this.app.getManager(59));
    this.jdField_a_of_type_Azwg = new azwg(this, this.app);
    this.jdField_a_of_type_Azwg.a(this);
    this.c = ((int)bacc.a(this, 12.0F));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131309736));
    this.jdField_a_of_type_ComTencentWidgetXListView.setNeedCheckSpringback(true);
    try
    {
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
      this.jdField_a_of_type_Alxg = new alxg(this, null);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Alxg);
      return true;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchResultActivity", 2, "infate failure:", paramBundle);
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = null;
    }
    if (this.jdField_a_of_type_Ajfw != null) {
      this.jdField_a_of_type_Ajfw.d(this.jdField_a_of_type_Ajgc);
    }
    if (this.jdField_a_of_type_Avev != null) {
      this.jdField_a_of_type_Avev.b(this.jdField_a_of_type_Avck);
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    int i;
    if (paramView != null)
    {
      if (!(paramView instanceof alxh)) {
        break label144;
      }
      paramView = (alxh)paramView;
      if (!this.app.getCurrentAccountUin().equals(paramView.jdField_a_of_type_JavaLangString)) {
        break label111;
      }
      i = 0;
    }
    for (;;)
    {
      awqx.b(this.app, "CliOper", "", "", "0X8006F0C", "0X8006F0C", 0, 0, "", "", "", "");
      Object localObject = new ProfileActivity.AllInOne(paramView.jdField_a_of_type_JavaLangString, i);
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_JavaLangString = paramView.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
      ((ProfileActivity.AllInOne)localObject).jdField_h_of_type_Int = 87;
      ProfileActivity.b(this, (ProfileActivity.AllInOne)localObject);
      label111:
      do
      {
        return;
        localObject = (ajjj)this.app.getManager(51);
        if ((localObject == null) || (!((ajjj)localObject).b(paramView.jdField_a_of_type_JavaLangString))) {
          break label180;
        }
        i = 1;
        break;
      } while ((!(paramView instanceof alxi)) || ((this.jdField_b_of_type_Int != 3) && (this.jdField_b_of_type_Int != 4)));
      label144:
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Alxg.notifyDataSetChanged();
      return;
      label180:
      i = 75;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 0))
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1).getTag();
        if ((localObject != null) && ((localObject instanceof alxh)))
        {
          localObject = (alxh)localObject;
          if (((alxh)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
            ((alxh)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Azwg.a();
      this.jdField_a_of_type_Azwg.c();
      return;
    }
    if (this.jdField_a_of_type_Azwg.a()) {
      this.jdField_a_of_type_Azwg.b();
    }
    this.jdField_a_of_type_Alxg.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity
 * JD-Core Version:    0.7.0.1
 */