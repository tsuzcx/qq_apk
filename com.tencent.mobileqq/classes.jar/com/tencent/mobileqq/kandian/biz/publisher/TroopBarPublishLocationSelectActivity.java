package com.tencent.mobileqq.kandian.biz.publisher;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.base.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.tribe.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xf9b.oidb_cmd0xf9b.Location;
import tencent.im.oidb.cmd0xf9b.oidb_cmd0xf9b.ReqBody;
import tencent.im.oidb.cmd0xf9b.oidb_cmd0xf9b.RspBody;

public class TroopBarPublishLocationSelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, LocationListCallback, AdapterView.OnItemClickListener
{
  public final TroopBarPOI a = new TroopBarPOI("-1", "", HardCodeUtil.a(2131912499), 0, "", 0, "");
  protected XListView b = null;
  protected TroopBarPublishLocationSelectActivity.LocationAdapter c = null;
  protected TroopBarPOI d = null;
  protected TroopBarPOI e = null;
  protected ArrayList<TroopBarPOI> f = null;
  protected View g = null;
  protected long h = 0L;
  protected PullRefreshHeader i;
  protected Drawable j;
  protected SosoInterfaceOnLocationListener k = null;
  protected boolean l = false;
  protected Handler m = new TroopBarPublishLocationSelectActivity.3(this);
  
  protected void a()
  {
    this.i = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131625671, this.b, false));
    Contacts.OverScrollViewTag localOverScrollViewTag = new Contacts.OverScrollViewTag();
    this.i.setTag(localOverScrollViewTag);
    this.b.setOverscrollHeader(getResources().getDrawable(2130839580));
    this.b.setOverScrollHeader(this.i);
    this.b.setOverScrollListener(new TroopBarPublishLocationSelectActivity.2(this));
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = (Contacts.OverScrollViewTag)((PullRefreshHeader)localObject).getTag();
      if (localObject != null)
      {
        ((Contacts.OverScrollViewTag)localObject).a = false;
        this.m.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.h = System.currentTimeMillis();
        }
        this.i.a(paramInt);
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, LocationListCallback paramLocationListCallback)
  {
    oidb_cmd0xf9b.ReqBody localReqBody = new oidb_cmd0xf9b.ReqBody();
    localReqBody.lat.set(paramInt1);
    localReqBody.lon.set(paramInt2);
    localReqBody.num.set(20);
    localReqBody.start.set(1);
    localReqBody.coordinate.set(1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("refresh_all_poi", true);
    ProtoUtils.a(BaseApplicationImpl.getApplication().getRuntime(), new TroopBarPublishLocationSelectActivity.5(this, paramLocationListCallback, localBundle), localReqBody.toByteArray(), "OidbSvc.0xf9b", 3995, 1);
  }
  
  protected void a(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.g.findViewById(2131444559);
    if (paramBoolean)
    {
      localTextView.setText(2131916806);
      return;
    }
    localTextView.setText(2131916801);
  }
  
  public void a(byte[] paramArrayOfByte, Bundle paramBundle)
  {
    oidb_cmd0xf9b.RspBody localRspBody = new oidb_cmd0xf9b.RspBody();
    int n;
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramArrayOfByte);
        a(true);
        b(false);
        if (this.f == null) {
          this.f = new ArrayList();
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("refresh_all_poi"))) {
          this.f.clear();
        }
        if (!this.f.isEmpty()) {
          break label371;
        }
        this.f.add(this.a);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.e("TroopBarPublishLocationSelectActivity", 1, paramArrayOfByte, new Object[0]);
        QQToast.makeText(this, 1, getString(2131894038), 0).show(getTitleBarHeight());
        return;
      }
      catch (JSONException paramArrayOfByte)
      {
        QLog.e("TroopBarPublishLocationSelectActivity", 1, paramArrayOfByte, new Object[0]);
        QQToast.makeText(this, 1, getString(2131894038), 0).show(getTitleBarHeight());
        return;
      }
      if (n < localRspBody.locations.size())
      {
        paramArrayOfByte = (oidb_cmd0xf9b.Location)localRspBody.locations.get(n);
        paramBundle = new JSONObject();
        paramBundle.put("uid", paramArrayOfByte.area_id.get().toStringUtf8());
        paramBundle.put("catalog", paramArrayOfByte.city.get().toStringUtf8());
        paramBundle.put("name", paramArrayOfByte.title.get().toStringUtf8());
        paramBundle.put("longitude", paramArrayOfByte.lon.get());
        paramBundle.put("addr", paramArrayOfByte.address.get().toStringUtf8());
        paramBundle.put("latitude", paramArrayOfByte.lat.get());
        paramBundle.put("dist", paramArrayOfByte.distance.get());
        this.f.add(new TroopBarPOI(paramBundle));
        n += 1;
      }
      else
      {
        if (this.f.size() <= 1) {
          break label376;
        }
        paramArrayOfByte = (TroopBarPOI)this.f.get(1);
      }
    }
    for (;;)
    {
      this.d = paramArrayOfByte;
      this.c.notifyDataSetChanged();
      return;
      label371:
      n = 0;
      break;
      label376:
      paramArrayOfByte = null;
    }
  }
  
  protected void b()
  {
    b(true);
    this.k = new TroopBarPublishLocationSelectActivity.4(this, 0, true, true, 0L, false, false, "QLifeCommentActivity");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.k);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.centerView != null) && (this.j == null))
      {
        this.j = getResources().getDrawable(2130839585);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.j, null, null, null);
        ((Animatable)this.j).start();
      }
    }
    else if (this.centerView != null)
    {
      Drawable localDrawable = this.j;
      if (localDrawable != null)
      {
        ((Animatable)localDrawable).stop();
        this.j = null;
        this.centerView.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = new XListView(this);
    this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.b.setDivider(getResources().getDrawable(2130841335));
    this.b.setDividerHeight(1);
    setContentView(this.b);
    setTitle(2131893998);
    this.rightViewImg.setImageResource(2130843552);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    paramBundle = getIntent();
    this.f = paramBundle.getParcelableArrayListExtra("current_location_list");
    this.l = paramBundle.getBooleanExtra("Transparent_Bg", false);
    this.e = ((TroopBarPOI)paramBundle.getParcelableExtra("key_selected_poi"));
    if (this.e == null) {
      this.e = this.a;
    }
    paramBundle = this.f;
    if (paramBundle != null)
    {
      if (paramBundle.isEmpty()) {
        paramBundle = null;
      } else {
        paramBundle = (TroopBarPOI)this.f.get(0);
      }
      this.d = paramBundle;
      this.f.add(0, this.a);
    }
    if (this.l) {
      this.b.setBackgroundResource(17170445);
    } else {
      this.b.setBackgroundResource(2130838958);
    }
    this.g = LayoutInflater.from(this).inflate(2131625671, null);
    a();
    paramBundle = (ImageView)this.g.findViewById(2131444557);
    TextView localTextView1 = (TextView)this.g.findViewById(2131444559);
    TextView localTextView2 = (TextView)this.g.findViewById(2131444565);
    ProgressBar localProgressBar = (ProgressBar)this.g.findViewById(2131444560);
    localTextView1.setTextColor(-8355712);
    localTextView1.setText(2131916801);
    localTextView2.setVisibility(8);
    paramBundle.setVisibility(8);
    localProgressBar.setVisibility(8);
    this.b.addFooterView(this.g);
    this.b.setOnScrollListener(new TroopBarPublishLocationSelectActivity.1(this));
    this.c = new TroopBarPublishLocationSelectActivity.LocationAdapter(this, this, this.l);
    this.b.setAdapter(this.c);
    this.b.setOnItemClickListener(this);
    b();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.k != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.k);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() != 2131436194) {
      return;
    }
    b();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.f;
    if ((paramAdapterView != null) && (paramInt >= 0))
    {
      if (paramInt >= paramAdapterView.size()) {
        return;
      }
      this.e = ((TroopBarPOI)this.f.get(paramInt));
      this.c.notifyDataSetChanged();
      if (this.a.equals(this.e)) {
        paramAdapterView = null;
      } else {
        paramAdapterView = this.e;
      }
      paramView = new Intent();
      paramView.putExtra("key_selected_poi", paramAdapterView);
      setResult(-1, paramView);
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */