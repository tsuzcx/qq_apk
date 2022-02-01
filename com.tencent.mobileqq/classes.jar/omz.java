import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.VideoInfo.GameAdDownloadInfo;
import com.tencent.biz.pubaccount.VideoInfo.KdTagItem;
import com.tencent.biz.pubaccount.readinjoy.ad.game_component.VideoFeedsGameAdComManager.2;
import com.tencent.biz.pubaccount.readinjoy.ad.game_component.VideoFeedsGameAdComManager.3;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class omz
  implements View.OnClickListener, ors
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + omz.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nxp jdField_a_of_type_Nxp;
  private omy jdField_a_of_type_Omy;
  private one jdField_a_of_type_One;
  private orb jdField_a_of_type_Orb;
  private oro jdField_a_of_type_Oro;
  private rwy jdField_a_of_type_Rwy;
  private rxy jdField_a_of_type_Rxy;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public omz(QQAppInterface paramQQAppInterface, Activity paramActivity, rwy paramrwy, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Omy = new omy(paramQQAppInterface);
    this.jdField_a_of_type_Int = bggq.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Rwy = paramrwy;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nxp = new nxp(paramActivity);
    this.jdField_a_of_type_Nxp.a(new ona(this));
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    nxw.a(new omp().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(nxw.af).c(nxw.as).d(nxw.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, rxy paramrxy)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rxy = paramrxy;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramrxy.v == null) && ((paramrxy instanceof rxv)))
    {
      paramrxy.v = ((ViewGroup)((ViewStub)paramrxy.r.findViewById(2131380672)).inflate());
      paramrxy.f = ((URLImageView)paramrxy.v.findViewById(2131367302));
      paramrxy.E = ((TextView)paramrxy.v.findViewById(2131367305));
      paramrxy.F = ((TextView)paramrxy.v.findViewById(2131367304));
      paramrxy.G = ((TextView)paramrxy.v.findViewById(2131367303));
      paramrxy.H = ((TextView)paramrxy.v.findViewById(2131367301));
    }
    if (paramrxy.v != null)
    {
      paramrxy.v.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bgey.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bgey.k);
      paramrxy.f.setImageDrawable(localURLDrawable);
      paramrxy.E.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramrxy.F.setText(paramGameAdComData.i);
      if (oqi.a()) {
        paramrxy.F.setTextColor(Color.parseColor("#80000000"));
      }
      paramrxy.v.setTag(paramrxy);
      paramrxy.G.setTag(paramrxy);
      paramrxy.H.setTag(paramrxy);
      paramrxy.v.setOnClickListener(this);
      paramrxy.G.setOnClickListener(this);
      paramrxy.H.setOnClickListener(this);
      paramrxy.v.setTag(2131380929, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramrxy);
      ryx.a(paramrxy.v, 200);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramGameAdComData.j);
        }
      }
    }
  }
  
  private boolean a(int paramInt, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    if (bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Orb.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = nxw.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Rxy.G.setVisibility(0);
        this.jdField_a_of_type_Rxy.H.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb)) {
          break;
        }
        DownloadInfo localDownloadInfo = bisa.a().c(this.jdField_a_of_type_Orb.d);
        bisa.a().a(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = nxw.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Rxy.G.setVisibility(0);
      this.jdField_a_of_type_Rxy.H.setVisibility(8);
      return true;
      if (!nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = nxw.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Rxy.G.setVisibility(0);
    this.jdField_a_of_type_Rxy.H.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (oqj.a(this.jdField_a_of_type_Omy)) {
      return true;
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString);
  }
  
  private String b()
  {
    Object localObject1 = "";
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("jump_page", 6);
      ((JSONObject)localObject2).put("jump_bus_type", 5);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, localException.getMessage());
    }
    return localObject1;
    return "";
  }
  
  private void b(rxy paramrxy)
  {
    Object localObject = anni.a(2131714922);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null) {
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        String str;
      }
    }
    bool = oqi.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131717033);
        paramrxy.G.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramrxy.G.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramrxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramrxy.G.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = anni.a(2131714855))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
        }
        paramrxy.G.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (nxw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = anni.a(2131714885))
          {
            paramrxy.G.setTextColor(-1);
            paramrxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramrxy.G.setText((CharSequence)localObject);
            return;
          }
        }
        if (bool)
        {
          str = "下载";
          label273:
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
            str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
          }
          paramrxy.G.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842840);
          paramrxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramrxy.G.setText(str);
          localObject = str;
          if (this.jdField_b_of_type_Boolean) {
            break;
          }
          localObject = str;
          if (this.jdField_c_of_type_Boolean) {
            break;
          }
          this.jdField_c_of_type_Boolean = true;
          b();
          return;
          str = anni.a(2131714853);
          break label273;
          label387:
          paramrxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = anni.a(2131714852);
      paramrxy.G.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramrxy.G.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramrxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;; localObject = anni.a(2131714827))
    {
      paramrxy.G.setTextColor(-1);
      break;
    }
  }
  
  private void c(rxy paramrxy)
  {
    if ((paramrxy != null) && (paramrxy.v != null)) {
      paramrxy.v.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Orb != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_Orb.d;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = bisa.a().c((String)localObject);
          if ((nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
          {
            h();
            return true;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private boolean f()
  {
    Object localObject = this.jdField_a_of_type_Orb.d;
    int i = nxw.af;
    i = nxw.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bgnw.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = nxw.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb))
    {
      localObject = bisa.a().c(this.jdField_a_of_type_Orb.d);
      bisa.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = nxw.af;
        i = nxw.e;
        localHashMap.put("download_state", "3");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    return false;
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_Orb == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 4)
        {
          a(4, d());
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 5)
        {
          localObject = this.jdField_a_of_type_Orb.d;
          if (bgnw.a(BaseApplicationImpl.getContext(), (String)localObject))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
            a(1, d());
            return;
          }
          a(5, d());
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3);
      a(3, d());
    } while ((this.jdField_a_of_type_Orb == null) || (this.jdField_a_of_type_Nxp == null));
    this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
    return;
    int i = nxw.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nxp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
      {
        i = nxw.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    oqh.a(jdField_a_of_type_JavaLangString, "queryCallback and download: appId is " + this.jdField_a_of_type_Orb.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Orb.e);
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
    {
      i = nxw.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Rxy.G.setVisibility(8);
    this.jdField_a_of_type_Rxy.H.setVisibility(0);
    if (!oqi.a())
    {
      this.jdField_a_of_type_Rxy.H.setText(anni.a(2131714888) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Rxy.H.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Rxy.H.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Rxy.H.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Rxy.G.setClickable(false);
      this.jdField_a_of_type_Rxy.v.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxy.H.setClickable(false);
      this.jdField_a_of_type_Rxy.G.setVisibility(0);
      this.jdField_a_of_type_Rxy.H.setVisibility(8);
      return;
      this.jdField_a_of_type_Rxy.G.setClickable(true);
      this.jdField_a_of_type_Rxy.v.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_One = new one(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void p()
  {
    if (b())
    {
      this.jdField_a_of_type_Rxy.G.setClickable(false);
      this.jdField_a_of_type_Rxy.v.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxy.H.setClickable(false);
      this.jdField_a_of_type_Rxy.G.setVisibility(0);
      this.jdField_a_of_type_Rxy.H.setVisibility(8);
      return;
      this.jdField_a_of_type_Rxy.G.setClickable(true);
      this.jdField_a_of_type_Rxy.v.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Orb != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Rxy.G.setClickable(true);
      this.jdField_a_of_type_Rxy.v.setClickable(true);
      this.jdField_a_of_type_Rxy.H.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rxy.G.setVisibility(0);
      this.jdField_a_of_type_Rxy.H.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Rxy.G.setClickable(false);
      this.jdField_a_of_type_Rxy.v.setClickable(false);
      this.jdField_a_of_type_Rxy.H.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Omy.a();
  }
  
  public omy a()
  {
    return this.jdField_a_of_type_Omy;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nxp != null) {
      this.jdField_a_of_type_Nxp.a();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = nxw.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)))
    {
      paramInt = nxw.e;
      localHashMap.put("download_state", "2");
      a(paramInt, localHashMap);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
    case 3: 
    case 5: 
    case 1: 
    case 4: 
      do
      {
        do
        {
          return;
          m();
          this.jdField_a_of_type_Rxy.G.setVisibility(8);
          this.jdField_a_of_type_Rxy.H.setVisibility(0);
          this.jdField_a_of_type_Rxy.H.setTextColor(Color.parseColor("#262626"));
        } while (!oqi.a());
        this.jdField_a_of_type_Rxy.H.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Rxy.G.setVisibility(0);
        this.jdField_a_of_type_Rxy.G.setText(anni.a(2131714839));
        if (oqi.a()) {
          this.jdField_a_of_type_Rxy.G.setText("安装");
        }
        this.jdField_a_of_type_Rxy.G.setTextColor(-1);
        this.jdField_a_of_type_Rxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rxy.H.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Rxy.G.setVisibility(0);
        this.jdField_a_of_type_Rxy.G.setText(anni.a(2131714817));
        if (oqi.a()) {
          this.jdField_a_of_type_Rxy.G.setText("打开");
        }
        this.jdField_a_of_type_Rxy.G.setTextColor(-1);
        this.jdField_a_of_type_Rxy.G.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rxy.H.setVisibility(8);
        return;
        this.jdField_a_of_type_Rxy.G.setVisibility(8);
        this.jdField_a_of_type_Rxy.H.setVisibility(0);
        this.jdField_a_of_type_Rxy.H.setText(anni.a(2131714908));
        this.jdField_a_of_type_Rxy.H.setTextColor(-1);
      } while (!oqi.a());
      this.jdField_a_of_type_Rxy.H.setText("继续");
      this.jdField_a_of_type_Rxy.H.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Rxy.G.setVisibility(0);
      this.jdField_a_of_type_Rxy.H.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anni.a(2131714898), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) && (this.jdField_a_of_type_One != null) && (this.jdField_a_of_type_One.a == paramLong)) {
      this.jdField_a_of_type_Rxy.G.post(new VideoFeedsGameAdComManager.2(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Oro != null))
    {
      this.jdField_a_of_type_Oro.a(paramConfiguration);
      this.jdField_a_of_type_Oro.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, rxy paramrxy)
  {
    if (paramrxy.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramrxy.v != null) && (paramrxy.v.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
      if ((paramVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
      {
        if ("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
        {
          o();
          if (c())
          {
            this.jdField_b_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramrxy);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        Object localObject = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            ((StringBuilder)localObject).append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        localObject = ((StringBuilder)localObject).toString();
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (localObject = "";; localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = ((String)localObject);
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          obj.a().a(paramrxy.getAdapterPosition());
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
            this.jdField_a_of_type_Omy.a();
          }
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
            obj.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.K);
          }
          paramrxy = "";
          paramVideoInfo = paramrxy;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramrxy;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramrxy = new HashMap();
          a(nxw.jdField_b_of_type_Int, paramrxy);
          oat.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(nxw.af), String.valueOf(nxw.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramrxy.v == null) || (paramrxy.v.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrxy.v.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
      this.jdField_a_of_type_Orb = orb.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(rxy paramrxy)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramrxy);
  }
  
  public void a(boolean paramBoolean)
  {
    oqc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new onc(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(rxy paramrxy, boolean paramBoolean)
  {
    if ((paramrxy.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramrxy.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1))
    {
      a(paramrxy.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramrxy.a.a, paramrxy);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Omy.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Nxp != null) && (this.jdField_a_of_type_Orb != null))
    {
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
      oqh.a(jdField_a_of_type_JavaLangString, "doQuery : appId is " + this.jdField_a_of_type_Orb.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_Orb.e);
      return;
    }
    oqh.a(jdField_a_of_type_JavaLangString, "doQuery cancel, manager is " + this.jdField_a_of_type_Nxp + " downloadData is " + this.jdField_a_of_type_Orb);
  }
  
  public void b(boolean paramBoolean)
  {
    oqc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new ond(this, paramBoolean));
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Nxp != null) && (this.jdField_a_of_type_Orb != null)) {
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb);
    }
    if (this.jdField_a_of_type_Rxy.H != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_One == null) {
      return false;
    }
    return ooh.a(null, this.jdField_a_of_type_One.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Orb != null) && (this.jdField_a_of_type_Nxp != null)) {
      this.jdField_a_of_type_Nxp.d(this.jdField_a_of_type_Orb);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Orb != null) && (this.jdField_a_of_type_Nxp != null)) {
      this.jdField_a_of_type_Nxp.a(this.jdField_a_of_type_Orb, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Orb != null))
    {
      if ((this.jdField_a_of_type_Orb.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Orb.d))) {
        oqj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Orb.d);
      }
    }
    else {
      return;
    }
    ubb.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Rxy == null) {
      return;
    }
    this.jdField_a_of_type_Rxy.H.setVisibility(8);
    int i = c();
    if (i == 1)
    {
      p();
      return;
    }
    if (i == 2)
    {
      q();
      return;
    }
    n();
  }
  
  protected void j()
  {
    try
    {
      if (this.jdField_a_of_type_Orb != null)
      {
        bool1 = bgnw.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Orb.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Rxy.G.setVisibility(8);
        this.jdField_a_of_type_Rxy.H.setVisibility(0);
        a(e(), d());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        boolean bool1 = false;
      }
      label118:
      this.jdField_a_of_type_Rxy.G.setVisibility(0);
      this.jdField_a_of_type_Rxy.H.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Orb != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (rxy)paramView.getTag();
    int i = nxw.af;
    int j = nxw.jdField_a_of_type_Int;
    localObject = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      String str = "";
      localObject = str;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        localObject = str;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
        }
      }
      oat.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(nxw.af), String.valueOf(nxw.jdField_a_of_type_Int), (String)localObject, b());
      label141:
      label190:
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          try
          {
            i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
            if (i == 1) {
              break;
            }
            if (i != 3) {
              break label190;
            }
            f();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        break;
      } while (this.jdField_a_of_type_Orb == null);
      if (!a(j, localException1, false)) {
        if (acrw.a())
        {
          if (i == 2) {
            b();
          }
        }
        else if (!f())
        {
          a(false);
          continue;
          for (;;)
          {
            try
            {
              if (this.jdField_a_of_type_Orb == null) {
                break label141;
              }
              if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue() != 2) {
                break;
              }
              boolean bool = a(j, localException1, true);
              if (bool) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3) {
                break label349;
              }
              e();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
              {
                localException1.put("download_state", "8");
                i = nxw.e;
              }
              a(i, localException1);
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
            }
            break;
            label349:
            if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 4)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 0) {}
            }
            else
            {
              c();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
              {
                localException2.put("download_state", "9");
                i = nxw.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          oqj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          opz.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omz
 * JD-Core Version:    0.7.0.1
 */