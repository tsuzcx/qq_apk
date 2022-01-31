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
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGameAdComManager.2;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class rcz
  implements View.OnClickListener, oez
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + rcz.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nos jdField_a_of_type_Nos;
  private oev jdField_a_of_type_Oev;
  private qyj jdField_a_of_type_Qyj;
  private raw jdField_a_of_type_Raw;
  private rbt jdField_a_of_type_Rbt;
  private rcy jdField_a_of_type_Rcy;
  private rdd jdField_a_of_type_Rdd;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public rcz(QQAppInterface paramQQAppInterface, Activity paramActivity, raw paramraw, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Rcy = new rcy(paramQQAppInterface);
    this.jdField_a_of_type_Int = bcwh.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Raw = paramraw;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nos = new nos(paramActivity, true, paramVideoFeedsRecyclerView);
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    noy.a(new obk().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(noy.ad).c(noy.ao).d(noy.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, rbt paramrbt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Rbt = paramrbt;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramrbt.r == null) && ((paramrbt instanceof rbs)))
    {
      paramrbt.r = ((ViewGroup)((ViewStub)paramrbt.p.findViewById(2131379654)).inflate());
      paramrbt.f = ((URLImageView)paramrbt.r.findViewById(2131367024));
      paramrbt.H = ((TextView)paramrbt.r.findViewById(2131367027));
      paramrbt.I = ((TextView)paramrbt.r.findViewById(2131367026));
      paramrbt.J = ((TextView)paramrbt.r.findViewById(2131367025));
      paramrbt.K = ((TextView)paramrbt.r.findViewById(2131367023));
    }
    if (paramrbt.r != null)
    {
      paramrbt.r.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bcuq.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bcuq.j);
      paramrbt.f.setImageDrawable(localURLDrawable);
      paramrbt.H.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramrbt.I.setText(paramGameAdComData.i);
      if (oed.a()) {
        paramrbt.I.setTextColor(Color.parseColor("#80000000"));
      }
      paramrbt.r.setTag(paramrbt);
      paramrbt.J.setTag(paramrbt);
      paramrbt.K.setTag(paramrbt);
      paramrbt.r.setOnClickListener(this);
      paramrbt.J.setOnClickListener(this);
      paramrbt.K.setOnClickListener(this);
      paramrbt.r.setTag(2131379913, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramrbt);
      rdm.a(paramrbt.r, 200);
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
    if (bdem.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qyj.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = noy.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Rbt.J.setVisibility(0);
        this.jdField_a_of_type_Rbt.K.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!noq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qyj)) {
          break;
        }
        DownloadInfo localDownloadInfo = bfgi.a().c(this.jdField_a_of_type_Qyj.d);
        bfgi.a().a(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = noy.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Rbt.J.setVisibility(0);
      this.jdField_a_of_type_Rbt.K.setVisibility(8);
      return true;
      if (!nop.a(this.jdField_a_of_type_Qyj, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = noy.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Rbt.J.setVisibility(0);
    this.jdField_a_of_type_Rbt.K.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (oee.a(this.jdField_a_of_type_Rcy)) {
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
  
  private void b(rbt paramrbt)
  {
    Object localObject = alpo.a(2131716633);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null) {
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r).intValue();
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
    bool = oed.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131718895);
        paramrbt.J.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramrbt.J.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramrbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramrbt.J.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = alpo.a(2131716566))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;
        }
        paramrbt.J.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (noy.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = alpo.a(2131716596))
          {
            paramrbt.J.setTextColor(-1);
            paramrbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramrbt.J.setText((CharSequence)localObject);
            return;
          }
        }
        if (bool)
        {
          str = "下载";
          label273:
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {
            str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;
          }
          paramrbt.J.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842502);
          paramrbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramrbt.J.setText(str);
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
          str = alpo.a(2131716564);
          break label273;
          label387:
          paramrbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = alpo.a(2131716563);
      paramrbt.J.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramrbt.J.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramrbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;; localObject = alpo.a(2131716538))
    {
      paramrbt.J.setTextColor(-1);
      break;
    }
  }
  
  private void c(rbt paramrbt)
  {
    if ((paramrbt != null) && (paramrbt.r != null)) {
      paramrbt.r.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Qyj != null)) {
      try
      {
        String str = this.jdField_a_of_type_Qyj.d;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = bfgi.a().c(str);
          if ((noq.a(this.jdField_a_of_type_AndroidAppActivity, str)) && (localDownloadInfo != null) && (localDownloadInfo.a() == 4))
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
    Object localObject = this.jdField_a_of_type_Qyj.d;
    int i = noy.ad;
    i = noy.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bdem.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = noy.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (noq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qyj))
    {
      localObject = bfgi.a().c(this.jdField_a_of_type_Qyj.d);
      bfgi.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = noy.ad;
        i = noy.e;
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
    if (this.jdField_a_of_type_Qyj == null) {}
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
          localObject = this.jdField_a_of_type_Qyj.d;
          if (bdem.a(BaseApplicationImpl.getContext(), (String)localObject))
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
    } while ((this.jdField_a_of_type_Qyj == null) || (this.jdField_a_of_type_Nos == null));
    this.jdField_a_of_type_Nos.a(this.jdField_a_of_type_Qyj);
    return;
    int i = noy.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nop.a(this.jdField_a_of_type_Qyj, e()))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = noy.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
    {
      i = noy.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Rbt.J.setVisibility(8);
    this.jdField_a_of_type_Rbt.K.setVisibility(0);
    if (!oed.a())
    {
      this.jdField_a_of_type_Rbt.K.setText(alpo.a(2131716599) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Rbt.K.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Rbt.K.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Rbt.K.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Rbt.J.setClickable(false);
      this.jdField_a_of_type_Rbt.r.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rbt.K.setClickable(false);
      this.jdField_a_of_type_Rbt.J.setVisibility(0);
      this.jdField_a_of_type_Rbt.K.setVisibility(8);
      return;
      this.jdField_a_of_type_Rbt.J.setClickable(true);
      this.jdField_a_of_type_Rbt.r.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Rdd = new rdd(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.t));
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
      this.jdField_a_of_type_Rbt.J.setClickable(false);
      this.jdField_a_of_type_Rbt.r.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rbt.K.setClickable(false);
      this.jdField_a_of_type_Rbt.J.setVisibility(0);
      this.jdField_a_of_type_Rbt.K.setVisibility(8);
      return;
      this.jdField_a_of_type_Rbt.J.setClickable(true);
      this.jdField_a_of_type_Rbt.r.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Qyj != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Rbt.J.setClickable(true);
      this.jdField_a_of_type_Rbt.r.setClickable(true);
      this.jdField_a_of_type_Rbt.K.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Rbt.J.setVisibility(0);
      this.jdField_a_of_type_Rbt.K.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Rbt.J.setClickable(false);
      this.jdField_a_of_type_Rbt.r.setClickable(false);
      this.jdField_a_of_type_Rbt.K.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Rcy.a();
  }
  
  public rcy a()
  {
    return this.jdField_a_of_type_Rcy;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nos != null) {
      this.jdField_a_of_type_Nos.b();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = noy.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)))
    {
      paramInt = noy.e;
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
          this.jdField_a_of_type_Rbt.J.setVisibility(8);
          this.jdField_a_of_type_Rbt.K.setVisibility(0);
          this.jdField_a_of_type_Rbt.K.setTextColor(Color.parseColor("#262626"));
        } while (!oed.a());
        this.jdField_a_of_type_Rbt.K.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Rbt.J.setVisibility(0);
        this.jdField_a_of_type_Rbt.J.setText(alpo.a(2131716550));
        if (oed.a()) {
          this.jdField_a_of_type_Rbt.J.setText("安装");
        }
        this.jdField_a_of_type_Rbt.J.setTextColor(-1);
        this.jdField_a_of_type_Rbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rbt.K.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Rbt.J.setVisibility(0);
        this.jdField_a_of_type_Rbt.J.setText(alpo.a(2131716528));
        if (oed.a()) {
          this.jdField_a_of_type_Rbt.J.setText("打开");
        }
        this.jdField_a_of_type_Rbt.J.setTextColor(-1);
        this.jdField_a_of_type_Rbt.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Rbt.K.setVisibility(8);
        return;
        this.jdField_a_of_type_Rbt.J.setVisibility(8);
        this.jdField_a_of_type_Rbt.K.setVisibility(0);
        this.jdField_a_of_type_Rbt.K.setText(alpo.a(2131716619));
        this.jdField_a_of_type_Rbt.K.setTextColor(-1);
      } while (!oed.a());
      this.jdField_a_of_type_Rbt.K.setText("继续");
      this.jdField_a_of_type_Rbt.K.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Rbt.J.setVisibility(0);
      this.jdField_a_of_type_Rbt.K.setVisibility(8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alpo.a(2131716609), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) && (this.jdField_a_of_type_Rdd != null) && (this.jdField_a_of_type_Rdd.a == paramLong)) {
      this.jdField_a_of_type_Rbt.J.post(new VideoFeedsGameAdComManager.1(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Oev != null))
    {
      this.jdField_a_of_type_Oev.a(paramConfiguration);
      this.jdField_a_of_type_Oev.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, rbt paramrbt)
  {
    if (paramrbt.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramrbt.r != null) && (paramrbt.r.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
      if ((paramVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
      {
        if ("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
        {
          o();
          if (c())
          {
            this.jdField_b_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramrbt);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        paramrbt = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            paramrbt.append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        paramrbt = paramrbt.toString();
        if (TextUtils.isEmpty(paramrbt)) {}
        for (paramrbt = "";; paramrbt = paramrbt.substring(0, paramrbt.length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = paramrbt;
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Rcy.a();
          paramrbt = "";
          paramVideoInfo = paramrbt;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramrbt;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramrbt = new HashMap();
          a(noy.jdField_b_of_type_Int, paramrbt);
          nrt.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(noy.ad), String.valueOf(noy.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramrbt.r == null) || (paramrbt.r.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramrbt.r.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) {
      this.jdField_a_of_type_Qyj = qyj.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(rbt paramrbt)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramrbt);
  }
  
  public void a(boolean paramBoolean)
  {
    ody.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new rdb(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(rbt paramrbt, boolean paramBoolean)
  {
    if ((paramrbt.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramrbt.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1))
    {
      a(paramrbt.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramrbt.a.a, paramrbt);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Rcy.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Nos != null) && (this.jdField_a_of_type_Qyj != null)) {
      this.jdField_a_of_type_Nos.b(this.jdField_a_of_type_Qyj);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    ody.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new rdc(this, paramBoolean));
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r).intValue();
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Nos != null) && (this.jdField_a_of_type_Qyj != null)) {
      this.jdField_a_of_type_Nos.a(this.jdField_a_of_type_Qyj);
    }
    if (this.jdField_a_of_type_Rbt.K != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Rdd == null) {
      return false;
    }
    return ocp.a(null, this.jdField_a_of_type_Rdd.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Qyj != null) && (this.jdField_a_of_type_Nos != null)) {
      this.jdField_a_of_type_Nos.e(this.jdField_a_of_type_Qyj);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Qyj != null) && (this.jdField_a_of_type_Nos != null)) {
      this.jdField_a_of_type_Nos.a(this.jdField_a_of_type_Qyj, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.2(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Qyj != null))
    {
      if ((this.jdField_a_of_type_Qyj.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qyj.d))) {
        oee.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qyj.d);
      }
    }
    else {
      return;
    }
    szl.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Rbt == null) {
      return;
    }
    this.jdField_a_of_type_Rbt.K.setVisibility(8);
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
      if (this.jdField_a_of_type_Qyj != null)
      {
        bool1 = bdem.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qyj.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Rbt.J.setVisibility(8);
        this.jdField_a_of_type_Rbt.K.setVisibility(0);
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
      this.jdField_a_of_type_Rbt.J.setVisibility(0);
      this.jdField_a_of_type_Rbt.K.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Qyj != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (rbt)paramView.getTag();
    int i = noy.ad;
    int j = noy.jdField_a_of_type_Int;
    localObject = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      localObject = "";
      paramView = (View)localObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        paramView = (View)localObject;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
          paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
        }
      }
      nrt.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(noy.ad), String.valueOf(noy.jdField_a_of_type_Int), paramView, b());
      label137:
      label177:
      do
      {
        for (;;)
        {
          return;
          try
          {
            i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r).intValue();
            if (i == 1) {
              break;
            }
            if (i != 3) {
              break label177;
            }
            f();
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
          }
        }
        break;
      } while (this.jdField_a_of_type_Qyj == null);
      if (!a(j, (HashMap)localObject, false)) {
        if (aaon.a())
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
              if (this.jdField_a_of_type_Qyj == null) {
                break label137;
              }
              if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r).intValue() != 2) {
                break;
              }
              boolean bool = a(j, (HashMap)localObject, true);
              if (bool) {
                break;
              }
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3) {
                break label334;
              }
              e();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
              {
                ((HashMap)localObject).put("download_state", "8");
                i = noy.e;
              }
              a(i, (HashMap)localObject);
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
            }
            break;
            label334:
            if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 4)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 0) {}
            }
            else
            {
              c();
              i = j;
              if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
              {
                ((HashMap)localObject).put("download_state", "9");
                i = noy.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          oee.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          odv.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.o, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rcz
 * JD-Core Version:    0.7.0.1
 */