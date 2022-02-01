package cooperation.qqfav.widget;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.qqfav.QfavUtil;

public class LocationDetailActivity
  extends PoiMapActivity
{
  public long a;
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private FadeIconImageView jdField_a_of_type_ComTencentWidgetFadeIconImageView = null;
  public FavoriteActionSheet a;
  public TextView b = null;
  public ImageView c = null;
  public String g;
  public String h;
  public String i;
  public String j = null;
  public boolean k = false;
  private boolean l = false;
  private boolean m = false;
  
  public LocationDetailActivity()
  {
    this.jdField_a_of_type_Long = -1L;
  }
  
  private int a()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    int n;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      n = 256;
    } else {
      n = 128;
    }
    return n | 0x50;
  }
  
  private Intent a()
  {
    if ((this.g != null) && (this.h != null))
    {
      Intent localIntent1 = getLocationData();
      Intent localIntent2 = localIntent1.putExtra("forward_type", -2).putExtra("forward_latitude", localIntent1.getStringExtra("latitude")).putExtra("forward_longitude", localIntent1.getStringExtra("longitude")).putExtra("forward_location", this.mCurPoiAdr).putExtra("forward_location_string", this.mCurPoiAdr);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.PATH_LOCATION_IMG);
      localStringBuilder.append(this.g);
      localStringBuilder.append("_");
      localStringBuilder.append(this.h);
      localStringBuilder.append(".png");
      localIntent2.putExtra("forward_thumb", localStringBuilder.toString()).putExtra("isFromFavorites", true).putExtra("title", this.mCurPoiName).putExtra("summary", this.mCurPoiAdr);
      return localIntent1;
    }
    return null;
  }
  
  @TargetApi(11)
  private void i()
  {
    if (this.b == null) {
      return;
    }
    if (TextUtils.isEmpty(this.j))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
    if (VersionUtils.e()) {
      this.b.setAlpha(0.9F);
    }
    this.b.setText(new QQText(this.j, 3, 22));
  }
  
  private void j()
  {
    QfavHelper.a(this, "", this.jdField_a_of_type_Long, 0L);
  }
  
  private void k()
  {
    setResult(-1, c(this));
    finish();
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(this, true, false, true, true, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(a(false));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new LocationDetailActivity.5(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteCurdListener(new LocationDetailActivity.6(this));
    boolean bool = b();
    if (!bool) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disablePostTable();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.enablePostTable();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initColorNoteController: checkShowFileColorNote[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("PoiMapActivity", 2, localStringBuilder.toString());
    }
  }
  
  private void m()
  {
    QfavReport.a(null, "User_Modify", 7, 0, getIntent().getIntExtra("category", 1));
    QfavHelper.b(this, "", this.jdField_a_of_type_Long);
    super.finish();
  }
  
  public IServiceInfo a(boolean paramBoolean)
  {
    return new LocationColorNoteServiceInfo(this, Long.valueOf(this.jdField_a_of_type_Long));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = a();
    if (localIntent != null)
    {
      localIntent.putExtras(paramBundle);
      ForwardBaseOption.a(getActivity(), localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
      return;
    }
    QQToast.a(this, 2131692205, 1, 2000).b(5);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = a(this);
    Intent localIntent = new Intent(b(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.jdField_a_of_type_Long);
    localIntent.putExtra("note", this.j);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    int n;
    if (paramBoolean) {
      n = 13322;
    } else {
      n = 13321;
    }
    QfavHelper.a(this, (String)localObject, localIntent, n);
  }
  
  protected boolean b()
  {
    return true;
  }
  
  protected boolean c()
  {
    this.k = true;
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (!localIColorNoteController.isColorNoteExist()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.canAddColorNote())
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
      return false;
    }
    this.k = false;
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null)
    {
      long l1 = this.jdField_a_of_type_Long;
      if ((l1 != -1L) && (l1 != 0L)) {
        localIColorNoteController.addHistoryNote();
      }
    }
    super.finish();
  }
  
  protected void h()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
    }
  }
  
  protected void initTitleBar()
  {
    Object localObject = super.getIntent().getExtras();
    this.i = ((Bundle)localObject).getString("loc");
    this.g = ((Bundle)localObject).getString("lat");
    this.h = ((Bundle)localObject).getString("lon");
    this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("favId");
    TextView localTextView2 = (TextView)findViewById(2131369202);
    localTextView2.setText(2131692234);
    localTextView2.setOnClickListener(new LocationDetailActivity.1(this));
    ((TextView)super.findViewById(2131369249)).setText(2131693810);
    TextView localTextView1 = (TextView)super.findViewById(2131369233);
    this.m = super.getIntent().getBooleanExtra("forNoteNewFavorite", false);
    if ((!this.m) && (!((Bundle)localObject).getBoolean("forNewFavorite", false)))
    {
      this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet = new LocationDetailActivity.2(this, this, new LocationDetailActivity.LocationActions(this), a(), 7, null);
      localTextView2.setText(((Bundle)localObject).getString("leftViewText"));
      localTextView1.setVisibility(8);
      this.c = ((ImageView)super.findViewById(2131369216));
      this.c.setVisibility(0);
      this.c.setImageResource(2130840347);
      this.c.setContentDescription(super.getString(2131694220));
      this.c.setOnClickListener(this.jdField_a_of_type_CooperationQqfavWidgetFavoriteActionSheet);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131369220));
      if (!QfavUtil.a())
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetFadeIconImageView;
        if (localObject != null)
        {
          ((FadeIconImageView)localObject).setVisibility(0);
          this.l = true;
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetFadeIconImageView;
        if (localObject != null) {
          ((FadeIconImageView)localObject).setVisibility(8);
        }
      }
    }
    else if (this.m)
    {
      localTextView1.setText(2131694583);
      localTextView1.setOnClickListener(new LocationDetailActivity.3(this));
    }
    else
    {
      localTextView2.setText(2131690529);
      localTextView1.setText(2131694457);
      localTextView1.setOnClickListener(new LocationDetailActivity.4(this));
    }
    localTextView1.setTag(localTextView1.getText());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        if (13321 == paramInt1)
        {
          super.finish();
        }
        else if ((13322 == paramInt1) && (paramIntent != null))
        {
          this.j = paramIntent.getStringExtra("note");
          i();
        }
      }
      paramIntent = this.c;
      if ((paramIntent != null) && (13322 != paramInt1) && (103 != paramInt1)) {
        paramIntent.setOnClickListener(null);
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    ImageView localImageView = this.c;
    if (localImageView != null) {
      localImageView.setOnClickListener(null);
    }
    finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.findViewById(2131377019);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if ((this.m) && (!super.getIntent().getBooleanExtra("forNewFavorite", false)))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f = super.getResources().getDisplayMetrics().density;
      this.b = new TextView(paramBundle.getContext());
      this.b.setId(2131371959);
      this.b.setBackgroundResource(2130839390);
      this.b.setMaxLines(3);
      int n = (int)(15.0F * f);
      this.b.setPadding(n, n, n, n);
      this.b.setTextColor(super.getResources().getColor(2131167056));
      this.b.setTextSize(14.0F);
      this.b.setIncludeFontPadding(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ((int)(f * 50.0F) + ImmersiveUtils.getStatusBarHeight(this));
      localLayoutParams.gravity = 48;
      paramBundle.addView(this.b, localLayoutParams);
    }
    this.j = super.getIntent().getStringExtra("note");
    this.hideJiejingIcon = true;
    if (this.jiejingIcon != null) {
      this.jiejingIcon.setVisibility(8);
    }
    i();
    if (this.jdField_a_of_type_Long != -1L)
    {
      getIntent().putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      l();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onDestroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      localIColorNoteController.onResume();
    }
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */