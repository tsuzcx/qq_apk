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
  private boolean aA = false;
  public String ao;
  public String ap;
  public String aq;
  public long ar = -1L;
  public TextView as = null;
  public String at = null;
  public ImageView au = null;
  public FavoriteActionSheet av;
  public boolean aw = false;
  private FadeIconImageView ax = null;
  private boolean ay = false;
  private IColorNoteController az;
  
  @TargetApi(11)
  private void m()
  {
    if (this.as == null) {
      return;
    }
    if (TextUtils.isEmpty(this.at))
    {
      this.as.setVisibility(8);
      return;
    }
    this.as.setVisibility(0);
    if (VersionUtils.e()) {
      this.as.setAlpha(0.9F);
    }
    this.as.setText(new QQText(this.at, 3, 22));
  }
  
  private int n()
  {
    IColorNoteController localIColorNoteController = this.az;
    int i;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      i = 256;
    } else {
      i = 128;
    }
    return i | 0x50;
  }
  
  private Intent o()
  {
    if ((this.ao != null) && (this.ap != null))
    {
      Intent localIntent1 = getLocationData();
      Intent localIntent2 = localIntent1.putExtra("forward_type", -2).putExtra("forward_latitude", localIntent1.getStringExtra("latitude")).putExtra("forward_longitude", localIntent1.getStringExtra("longitude")).putExtra("forward_location", this.mCurPoiAdr).putExtra("forward_location_string", this.mCurPoiAdr);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.PATH_LOCATION_IMG);
      localStringBuilder.append(this.ao);
      localStringBuilder.append("_");
      localStringBuilder.append(this.ap);
      localStringBuilder.append(".png");
      localIntent2.putExtra("forward_thumb", localStringBuilder.toString()).putExtra("isFromFavorites", true).putExtra("title", this.mCurPoiName).putExtra("summary", this.mCurPoiAdr);
      return localIntent1;
    }
    return null;
  }
  
  private void p()
  {
    QfavHelper.a(this, "", this.ar, 0L);
  }
  
  private void q()
  {
    setResult(-1, f(this));
    finish();
  }
  
  private void r()
  {
    this.az = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.az.init(this, true, false, true, true, 0);
    this.az.setServiceInfo(b(false));
    this.az.attachToActivity(this);
    this.az.setOnColorNoteAnimFinishListener(new LocationDetailActivity.5(this));
    this.az.setOnColorNoteCurdListener(new LocationDetailActivity.6(this));
    boolean bool = j();
    if (!bool) {
      this.az.disablePostTable();
    } else {
      this.az.enablePostTable();
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
  
  private void s()
  {
    QfavReport.a(null, "User_Modify", 7, 0, getIntent().getIntExtra("category", 1));
    QfavHelper.b(this, "", this.ar);
    super.finish();
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = o();
    if (localIntent != null)
    {
      localIntent.putExtras(paramBundle);
      ForwardBaseOption.a(getActivity(), localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_shoucang");
      return;
    }
    QQToast.makeText(this, 2131889192, 1, 2000).show(5);
  }
  
  protected void a(boolean paramBoolean)
  {
    Object localObject = d(this);
    Intent localIntent = new Intent(e(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.ar);
    localIntent.putExtra("note", this.at);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    int i;
    if (paramBoolean) {
      i = 13322;
    } else {
      i = 13321;
    }
    QfavHelper.a(this, (String)localObject, localIntent, i);
  }
  
  public IServiceInfo b(boolean paramBoolean)
  {
    return new LocationColorNoteServiceInfo(this, Long.valueOf(this.ar));
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
    IColorNoteController localIColorNoteController = this.az;
    if (localIColorNoteController != null)
    {
      long l = this.ar;
      if ((l != -1L) && (l != 0L)) {
        localIColorNoteController.addHistoryNote();
      }
    }
    super.finish();
  }
  
  protected void initTitleBar()
  {
    Object localObject = super.getIntent().getExtras();
    this.aq = ((Bundle)localObject).getString("loc");
    this.ao = ((Bundle)localObject).getString("lat");
    this.ap = ((Bundle)localObject).getString("lon");
    this.ar = ((Bundle)localObject).getLong("favId");
    TextView localTextView2 = (TextView)findViewById(2131436180);
    localTextView2.setText(2131889221);
    localTextView2.setOnClickListener(new LocationDetailActivity.1(this));
    ((TextView)super.findViewById(2131436227)).setText(2131891386);
    TextView localTextView1 = (TextView)super.findViewById(2131436211);
    this.aA = super.getIntent().getBooleanExtra("forNoteNewFavorite", false);
    if ((!this.aA) && (!((Bundle)localObject).getBoolean("forNewFavorite", false)))
    {
      this.av = new LocationDetailActivity.2(this, this, new LocationDetailActivity.LocationActions(this), n(), 7, null);
      localTextView2.setText(((Bundle)localObject).getString("leftViewText"));
      localTextView1.setVisibility(8);
      this.au = ((ImageView)super.findViewById(2131436194));
      this.au.setVisibility(0);
      this.au.setImageResource(2130841087);
      this.au.setContentDescription(super.getString(2131891858));
      this.au.setOnClickListener(this.av);
      this.ax = ((FadeIconImageView)findViewById(2131436198));
      if (!QfavUtil.a())
      {
        localObject = this.ax;
        if (localObject != null)
        {
          ((FadeIconImageView)localObject).setVisibility(0);
          this.ay = true;
        }
      }
      else
      {
        localObject = this.ax;
        if (localObject != null) {
          ((FadeIconImageView)localObject).setVisibility(8);
        }
      }
    }
    else if (this.aA)
    {
      localTextView1.setText(2131892267);
      localTextView1.setOnClickListener(new LocationDetailActivity.3(this));
    }
    else
    {
      localTextView2.setText(2131887440);
      localTextView1.setText(2131892137);
      localTextView1.setOnClickListener(new LocationDetailActivity.4(this));
    }
    localTextView1.setTag(localTextView1.getText());
  }
  
  protected boolean j()
  {
    return true;
  }
  
  protected boolean k()
  {
    this.aw = true;
    IColorNoteController localIColorNoteController = this.az;
    if ((localIColorNoteController != null) && (!localIColorNoteController.isColorNoteExist()))
    {
      if (this.az.canAddColorNote())
      {
        this.az.insertColorNote();
        return true;
      }
      this.az.onCannotAdd();
      return false;
    }
    this.aw = false;
    return false;
  }
  
  protected void l()
  {
    IColorNoteController localIColorNoteController = this.az;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      this.az.deleteColorNote();
    }
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
          this.at = paramIntent.getStringExtra("note");
          m();
        }
      }
      paramIntent = this.au;
      if ((paramIntent != null) && (13322 != paramInt1) && (103 != paramInt1)) {
        paramIntent.setOnClickListener(null);
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    ImageView localImageView = this.au;
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
    paramBundle = super.findViewById(2131445383);
    paramBundle.setFocusable(false);
    paramBundle.setContentDescription(null);
    if ((this.aA) && (!super.getIntent().getBooleanExtra("forNewFavorite", false)))
    {
      paramBundle = (FrameLayout)super.findViewById(16908290);
      float f = super.getResources().getDisplayMetrics().density;
      this.as = new TextView(paramBundle.getContext());
      this.as.setId(2131439404);
      this.as.setBackgroundResource(2130839574);
      this.as.setMaxLines(3);
      int i = (int)(15.0F * f);
      this.as.setPadding(i, i, i, i);
      this.as.setTextColor(super.getResources().getColor(2131167993));
      this.as.setTextSize(14.0F);
      this.as.setIncludeFontPadding(false);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
      localLayoutParams.topMargin = ((int)(f * 50.0F) + ImmersiveUtils.getStatusBarHeight(this));
      localLayoutParams.gravity = 48;
      paramBundle.addView(this.as, localLayoutParams);
    }
    this.at = super.getIntent().getStringExtra("note");
    this.hideJiejingIcon = true;
    if (this.jiejingIcon != null) {
      this.jiejingIcon.setVisibility(8);
    }
    m();
    if (this.ar != -1L)
    {
      getIntent().putExtra("big_brother_source_key", "biz_src_jc_shoucang");
      getWindow().setBackgroundDrawable(new ColorDrawable(0));
      r();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    IColorNoteController localIColorNoteController = this.az;
    if (localIColorNoteController != null) {
      localIColorNoteController.onDestroy();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    IColorNoteController localIColorNoteController = this.az;
    if (localIColorNoteController != null) {
      localIColorNoteController.onPause();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    IColorNoteController localIColorNoteController = this.az;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */