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

public class qnv
  implements View.OnClickListener, obh
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qnv.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nlw jdField_a_of_type_Nlw;
  private obd jdField_a_of_type_Obd;
  private qjc jdField_a_of_type_Qjc;
  private qlp jdField_a_of_type_Qlp;
  private qmp jdField_a_of_type_Qmp;
  private qnu jdField_a_of_type_Qnu;
  private qnz jdField_a_of_type_Qnz;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public qnv(QQAppInterface paramQQAppInterface, Activity paramActivity, qlp paramqlp, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Qnu = new qnu(paramQQAppInterface);
    this.jdField_a_of_type_Int = baxn.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Qlp = paramqlp;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nlw = new nlw(paramActivity, true, paramVideoFeedsRecyclerView);
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    nmc.a(new nyd().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(nmc.ad).c(nmc.ao).d(nmc.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, qmp paramqmp)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qmp = paramqmp;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramqmp.q == null) && ((paramqmp instanceof qmo)))
    {
      paramqmp.q = ((ViewGroup)((ViewStub)paramqmp.o.findViewById(2131378990)).inflate());
      paramqmp.e = ((URLImageView)paramqmp.q.findViewById(2131366907));
      paramqmp.H = ((TextView)paramqmp.q.findViewById(2131366910));
      paramqmp.I = ((TextView)paramqmp.q.findViewById(2131366909));
      paramqmp.J = ((TextView)paramqmp.q.findViewById(2131366908));
      paramqmp.K = ((TextView)paramqmp.q.findViewById(2131366906));
    }
    if (paramqmp.q != null)
    {
      paramqmp.q.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bavw.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bavw.j);
      paramqmp.e.setImageDrawable(localURLDrawable);
      paramqmp.H.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramqmp.I.setText(paramGameAdComData.i);
      if (oaq.a()) {
        paramqmp.I.setTextColor(Color.parseColor("#80000000"));
      }
      paramqmp.q.setTag(paramqmp);
      paramqmp.J.setTag(paramqmp);
      paramqmp.K.setTag(paramqmp);
      paramqmp.q.setOnClickListener(this);
      paramqmp.J.setOnClickListener(this);
      paramqmp.K.setOnClickListener(this);
      paramqmp.q.setTag(2131379213, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramqmp);
      qoi.a(paramqmp.q, 200);
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
    if (bbfr.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qjc.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = nmc.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Qmp.J.setVisibility(0);
        this.jdField_a_of_type_Qmp.K.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!nlu.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjc)) {
          break;
        }
        DownloadInfo localDownloadInfo = bdhk.a().c(this.jdField_a_of_type_Qjc.d);
        bdhk.a().a(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = nmc.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Qmp.J.setVisibility(0);
      this.jdField_a_of_type_Qmp.K.setVisibility(8);
      return true;
      if (!nlt.a(this.jdField_a_of_type_Qjc, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = nmc.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Qmp.J.setVisibility(0);
    this.jdField_a_of_type_Qmp.K.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (oar.a(this.jdField_a_of_type_Qnu)) {
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
  
  private void b(qmp paramqmp)
  {
    Object localObject = ajya.a(2131716261);
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
    bool = oaq.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131718466);
        paramqmp.J.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramqmp.J.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramqmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramqmp.J.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = ajya.a(2131716194))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;
        }
        paramqmp.J.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (nmc.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = ajya.a(2131716224))
          {
            paramqmp.J.setTextColor(-1);
            paramqmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramqmp.J.setText((CharSequence)localObject);
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
          paramqmp.J.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842333);
          paramqmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramqmp.J.setText(str);
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
          str = ajya.a(2131716192);
          break label273;
          label387:
          paramqmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = ajya.a(2131716191);
      paramqmp.J.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramqmp.J.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramqmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;; localObject = ajya.a(2131716166))
    {
      paramqmp.J.setTextColor(-1);
      break;
    }
  }
  
  private void c(qmp paramqmp)
  {
    if ((paramqmp != null) && (paramqmp.q != null)) {
      paramqmp.q.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Qjc != null)) {
      try
      {
        String str = this.jdField_a_of_type_Qjc.d;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = bdhk.a().c(str);
          if ((nlu.a(this.jdField_a_of_type_AndroidAppActivity, str)) && (localDownloadInfo != null) && (localDownloadInfo.a() == 4))
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
    Object localObject = this.jdField_a_of_type_Qjc.d;
    int i = nmc.ad;
    i = nmc.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bbfr.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nmc.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (nlu.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjc))
    {
      localObject = bdhk.a().c(this.jdField_a_of_type_Qjc.d);
      bdhk.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nmc.ad;
        i = nmc.e;
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
    if (this.jdField_a_of_type_Qjc == null) {}
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
          localObject = this.jdField_a_of_type_Qjc.d;
          if (bbfr.a(BaseApplicationImpl.getContext(), (String)localObject))
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
    } while ((this.jdField_a_of_type_Qjc == null) || (this.jdField_a_of_type_Nlw == null));
    this.jdField_a_of_type_Nlw.a(this.jdField_a_of_type_Qjc);
    return;
    int i = nmc.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nlt.a(this.jdField_a_of_type_Qjc, e()))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nmc.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
    {
      i = nmc.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Qmp.J.setVisibility(8);
    this.jdField_a_of_type_Qmp.K.setVisibility(0);
    if (!oaq.a())
    {
      this.jdField_a_of_type_Qmp.K.setText(ajya.a(2131716227) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Qmp.K.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Qmp.K.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Qmp.K.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Qmp.J.setClickable(false);
      this.jdField_a_of_type_Qmp.q.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qmp.K.setClickable(false);
      this.jdField_a_of_type_Qmp.J.setVisibility(0);
      this.jdField_a_of_type_Qmp.K.setVisibility(8);
      return;
      this.jdField_a_of_type_Qmp.J.setClickable(true);
      this.jdField_a_of_type_Qmp.q.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Qnz = new qnz(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.t));
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
      this.jdField_a_of_type_Qmp.J.setClickable(false);
      this.jdField_a_of_type_Qmp.q.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qmp.K.setClickable(false);
      this.jdField_a_of_type_Qmp.J.setVisibility(0);
      this.jdField_a_of_type_Qmp.K.setVisibility(8);
      return;
      this.jdField_a_of_type_Qmp.J.setClickable(true);
      this.jdField_a_of_type_Qmp.q.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Qjc != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjc.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Qmp.J.setClickable(true);
      this.jdField_a_of_type_Qmp.q.setClickable(true);
      this.jdField_a_of_type_Qmp.K.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qmp.J.setVisibility(0);
      this.jdField_a_of_type_Qmp.K.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Qmp.J.setClickable(false);
      this.jdField_a_of_type_Qmp.q.setClickable(false);
      this.jdField_a_of_type_Qmp.K.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Qnu.a();
  }
  
  public qnu a()
  {
    return this.jdField_a_of_type_Qnu;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nlw != null) {
      this.jdField_a_of_type_Nlw.b();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = nmc.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)))
    {
      paramInt = nmc.e;
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
          this.jdField_a_of_type_Qmp.J.setVisibility(8);
          this.jdField_a_of_type_Qmp.K.setVisibility(0);
          this.jdField_a_of_type_Qmp.K.setTextColor(Color.parseColor("#262626"));
        } while (!oaq.a());
        this.jdField_a_of_type_Qmp.K.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Qmp.J.setVisibility(0);
        this.jdField_a_of_type_Qmp.J.setText(ajya.a(2131716178));
        if (oaq.a()) {
          this.jdField_a_of_type_Qmp.J.setText("安装");
        }
        this.jdField_a_of_type_Qmp.J.setTextColor(-1);
        this.jdField_a_of_type_Qmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Qmp.K.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Qmp.J.setVisibility(0);
        this.jdField_a_of_type_Qmp.J.setText(ajya.a(2131716156));
        if (oaq.a()) {
          this.jdField_a_of_type_Qmp.J.setText("打开");
        }
        this.jdField_a_of_type_Qmp.J.setTextColor(-1);
        this.jdField_a_of_type_Qmp.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Qmp.K.setVisibility(8);
        return;
        this.jdField_a_of_type_Qmp.J.setVisibility(8);
        this.jdField_a_of_type_Qmp.K.setVisibility(0);
        this.jdField_a_of_type_Qmp.K.setText(ajya.a(2131716247));
        this.jdField_a_of_type_Qmp.K.setTextColor(-1);
      } while (!oaq.a());
      this.jdField_a_of_type_Qmp.K.setText("继续");
      this.jdField_a_of_type_Qmp.K.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Qmp.J.setVisibility(0);
      this.jdField_a_of_type_Qmp.K.setVisibility(8);
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, ajya.a(2131716237), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) && (this.jdField_a_of_type_Qnz != null) && (this.jdField_a_of_type_Qnz.a == paramLong)) {
      this.jdField_a_of_type_Qmp.J.post(new VideoFeedsGameAdComManager.1(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Obd != null))
    {
      this.jdField_a_of_type_Obd.a(paramConfiguration);
      this.jdField_a_of_type_Obd.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, qmp paramqmp)
  {
    if (paramqmp.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramqmp.q != null) && (paramqmp.q.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
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
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramqmp);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        paramqmp = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            paramqmp.append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        paramqmp = paramqmp.toString();
        if (TextUtils.isEmpty(paramqmp)) {}
        for (paramqmp = "";; paramqmp = paramqmp.substring(0, paramqmp.length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = paramqmp;
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Qnu.a();
          paramqmp = "";
          paramVideoInfo = paramqmp;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramqmp;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramqmp = new HashMap();
          a(nmc.jdField_b_of_type_Int, paramqmp);
          nol.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(nmc.ad), String.valueOf(nmc.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramqmp.q == null) || (paramqmp.q.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramqmp.q.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) {
      this.jdField_a_of_type_Qjc = qjc.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(qmp paramqmp)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramqmp);
  }
  
  public void a(boolean paramBoolean)
  {
    oal.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new qnx(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(qmp paramqmp, boolean paramBoolean)
  {
    if ((paramqmp.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramqmp.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1))
    {
      a(paramqmp.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramqmp.a.a, paramqmp);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Qnu.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Nlw != null) && (this.jdField_a_of_type_Qjc != null)) {
      this.jdField_a_of_type_Nlw.b(this.jdField_a_of_type_Qjc);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    oal.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new qny(this, paramBoolean));
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
    if ((this.jdField_a_of_type_Nlw != null) && (this.jdField_a_of_type_Qjc != null)) {
      this.jdField_a_of_type_Nlw.a(this.jdField_a_of_type_Qjc);
    }
    if (this.jdField_a_of_type_Qmp.K != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Qnz == null) {
      return false;
    }
    return nzf.a(null, this.jdField_a_of_type_Qnz.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Qjc != null) && (this.jdField_a_of_type_Nlw != null)) {
      this.jdField_a_of_type_Nlw.e(this.jdField_a_of_type_Qjc);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Qjc != null) && (this.jdField_a_of_type_Nlw != null)) {
      this.jdField_a_of_type_Nlw.a(this.jdField_a_of_type_Qjc, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.2(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Qjc != null))
    {
      if ((this.jdField_a_of_type_Qjc.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjc.d))) {
        oar.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjc.d);
      }
    }
    else {
      return;
    }
    shq.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Qmp == null) {
      return;
    }
    this.jdField_a_of_type_Qmp.K.setVisibility(8);
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
      if (this.jdField_a_of_type_Qjc != null)
      {
        bool1 = bbfr.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qjc.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Qmp.J.setVisibility(8);
        this.jdField_a_of_type_Qmp.K.setVisibility(0);
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
      this.jdField_a_of_type_Qmp.J.setVisibility(0);
      this.jdField_a_of_type_Qmp.K.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Qjc != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (qmp)paramView.getTag();
    int i = nmc.ad;
    int j = nmc.jdField_a_of_type_Int;
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
      nol.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(nmc.ad), String.valueOf(nmc.jdField_a_of_type_Int), paramView, b());
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
      } while (this.jdField_a_of_type_Qjc == null);
      if (!a(j, (HashMap)localObject, false)) {
        if (yyn.a())
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
              if (this.jdField_a_of_type_Qjc == null) {
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
                i = nmc.e;
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
                i = nmc.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          oar.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          oai.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.o, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnv
 * JD-Core Version:    0.7.0.1
 */