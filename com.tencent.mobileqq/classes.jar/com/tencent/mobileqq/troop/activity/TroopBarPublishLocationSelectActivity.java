package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishLocationSelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, HttpWebCgiAsyncTask.Callback, AdapterView.OnItemClickListener
{
  protected long a;
  protected Drawable a;
  protected Handler a;
  protected View a;
  protected SosoInterfaceOnLocationListener a;
  public final TroopBarPOI a;
  protected TroopBarPublishLocationSelectActivity.LocationAdapter a;
  protected PullRefreshHeader a;
  protected XListView a;
  private String a;
  protected ArrayList<TroopBarPOI> a;
  protected boolean a;
  protected TroopBarPOI b = null;
  protected TroopBarPOI c = null;
  
  public TroopBarPublishLocationSelectActivity()
  {
    this.jdField_a_of_type_JavaLangString = "TroopBarPublishLocationSelectActivity";
    this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI = new TroopBarPOI("-1", "", HardCodeUtil.a(2131715007), 0, "", 0, "");
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter = null;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new TroopBarPublishLocationSelectActivity.3(this);
  }
  
  protected static final void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("lat", String.valueOf(paramInt1));
    localBundle1.putString("lon", String.valueOf(paramInt2));
    localBundle1.putString("num", String.valueOf(50));
    localBundle1.putString("start", String.valueOf(paramInt3));
    Bundle localBundle2 = new Bundle();
    if (paramBoolean) {
      localBundle2.putBoolean("refresh_all_poi", paramBoolean);
    }
    TroopBarUtils.a(paramBaseActivity, localBundle1, "https://buluo.qq.com/cgi-bin/bar/user/poilist", 3, localBundle2, paramCallback);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559642, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(localOverScrollViewTag);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverscrollHeader(getResources().getDrawable(2130839396));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(new TroopBarPublishLocationSelectActivity.2(this));
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader;
    if (localObject != null)
    {
      localObject = (Contacts.OverScrollViewTag)((PullRefreshHeader)localObject).getTag();
      if (localObject != null)
      {
        ((Contacts.OverScrollViewTag)localObject).jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.jdField_a_of_type_Long = System.currentTimeMillis();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader.a(paramInt);
      }
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    b(true);
    TroopBarPOI localTroopBarPOI = this.b;
    if (localTroopBarPOI != null)
    {
      a(this, localTroopBarPOI.b, this.b.a, paramInt, paramBoolean, this);
      return;
    }
    b();
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramInt != 3) {
      return;
    }
    b(false);
    boolean bool;
    if (paramJSONObject != null) {
      for (;;)
      {
        try
        {
          if (paramJSONObject.optInt("isend", -1) != 1) {
            break label318;
          }
          bool = true;
          a(bool);
          localJSONArray = paramJSONObject.getJSONArray("poilist");
          if (this.jdField_a_of_type_JavaUtilArrayList == null) {
            this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
          }
          if ((paramBundle != null) && (paramBundle.getBoolean("refresh_all_poi"))) {
            this.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            break label324;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI);
        }
        catch (JSONException paramBundle)
        {
          JSONArray localJSONArray;
          label109:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopBar", 2, paramBundle.toString());
          if (paramJSONObject.optInt("isend", -1) == 1) {
            break label317;
          }
        }
        if (paramInt < localJSONArray.length())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(new TroopBarPOI(localJSONArray.getJSONObject(paramInt)));
          paramInt += 1;
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
            break label329;
          }
          paramBundle = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(1);
        }
      }
    }
    for (;;)
    {
      this.b = paramBundle;
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter.notifyDataSetChanged();
      return;
      paramInt = paramJSONObject.optInt("retcode", -1);
      if (paramInt != 0)
      {
        QQToast.a(this, 1, getString(2131696273, new Object[] { Integer.valueOf(paramInt) }), 0).b(getTitleBarHeight());
        return;
      }
      QQToast.a(this, 1, getString(2131696273, new Object[] { Integer.valueOf(paramJSONObject.optInt("errno", -1)) }), 0).b(getTitleBarHeight());
      return;
      QQToast.a(this, 1, 2131696272, 0).b(getTitleBarHeight());
      label317:
      return;
      label318:
      bool = false;
      break;
      label324:
      paramInt = 0;
      break label109;
      label329:
      paramBundle = null;
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376344);
    if (paramBoolean)
    {
      localTextView.setText(2131719254);
      return;
    }
    localTextView.setText(2131719249);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = new TroopBarPublishLocationSelectActivity.4(this, 0, true, true, 0L, false, false, "QLifeCommentActivity");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.centerView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839401);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
      }
    }
    else if (this.centerView != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        this.centerView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetXListView = new XListView(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(getResources().getDrawable(2130840569));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(1);
    setContentView(this.jdField_a_of_type_ComTencentWidgetXListView);
    setTitle(2131696232);
    this.rightViewImg.setImageResource(2130842599);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    paramBundle = getIntent();
    this.jdField_a_of_type_JavaUtilArrayList = paramBundle.getParcelableArrayListExtra("current_location_list");
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("Transparent_Bg", false);
    this.c = ((TroopBarPOI)paramBundle.getParcelableExtra("key_selected_poi"));
    if (this.c == null) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI;
    }
    paramBundle = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramBundle != null)
    {
      if (paramBundle.isEmpty()) {
        paramBundle = null;
      } else {
        paramBundle = (TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      }
      this.b = paramBundle;
      this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(17170445);
    } else {
      this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838739);
    }
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131559642, null);
    a();
    paramBundle = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376342);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376344);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376350);
    ProgressBar localProgressBar = (ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131376345);
    localTextView1.setTextColor(-8355712);
    localTextView1.setText(2131719249);
    localTextView2.setVisibility(8);
    paramBundle.setVisibility(8);
    localProgressBar.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new TroopBarPublishLocationSelectActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter = new TroopBarPublishLocationSelectActivity.LocationAdapter(this, this, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    a(0, true);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369216) {
      a(0, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.jdField_a_of_type_JavaUtilArrayList;
    if ((paramAdapterView != null) && (paramInt >= 0))
    {
      if (paramInt >= paramAdapterView.size()) {
        return;
      }
      this.c = ((TroopBarPOI)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$LocationAdapter.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqTribeDataTroopBarPOI.equals(this.c)) {
        paramAdapterView = null;
      } else {
        paramAdapterView = this.c;
      }
      paramView = new Intent();
      paramView.putExtra("key_selected_poi", paramAdapterView);
      setResult(-1, paramView);
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */