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

public class qca
  implements View.OnClickListener, npz
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qca.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nay jdField_a_of_type_Nay;
  private npv jdField_a_of_type_Npv;
  private pxh jdField_a_of_type_Pxh;
  private pzs jdField_a_of_type_Pzs;
  private qaq jdField_a_of_type_Qaq;
  private qbz jdField_a_of_type_Qbz;
  private qce jdField_a_of_type_Qce;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public qca(QQAppInterface paramQQAppInterface, Activity paramActivity, pzs parampzs, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Qbz = new qbz(paramQQAppInterface);
    this.jdField_a_of_type_Int = azvv.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Pzs = parampzs;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nay = new nay(paramActivity, true, paramVideoFeedsRecyclerView);
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    nbe.a(new nmv().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(nbe.ad).c(nbe.ao).d(nbe.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, qaq paramqaq)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qaq = paramqaq;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramqaq.s == null) && ((paramqaq instanceof qap)))
    {
      paramqaq.s = ((ViewGroup)((ViewStub)paramqaq.q.findViewById(2131313154)).inflate());
      paramqaq.e = ((URLImageView)paramqaq.s.findViewById(2131301296));
      paramqaq.B = ((TextView)paramqaq.s.findViewById(2131301299));
      paramqaq.C = ((TextView)paramqaq.s.findViewById(2131301298));
      paramqaq.D = ((TextView)paramqaq.s.findViewById(2131301297));
      paramqaq.E = ((TextView)paramqaq.s.findViewById(2131301295));
    }
    if (paramqaq.s != null)
    {
      paramqaq.s.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(azue.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(azue.j);
      paramqaq.e.setImageDrawable(localURLDrawable);
      paramqaq.B.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramqaq.C.setText(paramGameAdComData.i);
      paramqaq.s.setTag(paramqaq);
      paramqaq.D.setTag(paramqaq);
      paramqaq.E.setTag(paramqaq);
      paramqaq.s.setOnClickListener(this);
      paramqaq.D.setOnClickListener(this);
      paramqaq.E.setOnClickListener(this);
      paramqaq.s.setTag(2131313373, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramqaq);
      qcn.a(paramqaq.s, 200);
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
    if (bady.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Pxh.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = nbe.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Qaq.D.setVisibility(0);
        this.jdField_a_of_type_Qaq.E.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!naw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Pxh)) {
          break;
        }
        DownloadInfo localDownloadInfo = bccu.a().c(this.jdField_a_of_type_Pxh.d);
        bccu.a().c(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = nbe.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      return true;
      if (!nav.a(this.jdField_a_of_type_Pxh, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = nbe.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Qaq.D.setVisibility(0);
    this.jdField_a_of_type_Qaq.E.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (npj.a(this.jdField_a_of_type_Qbz)) {
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
  
  private void b(qaq paramqaq)
  {
    Object localObject = ajjy.a(2131650459);
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
      label34:
      label360:
      break label34;
    }
    if (i == 1) {
      if (b())
      {
        localObject = BaseApplicationImpl.getContext().getResources().getString(2131652636);
        paramqaq.D.setTextColor(Color.parseColor("#262626"));
        paramqaq.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramqaq.D.setText((CharSequence)localObject);
      return;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {}
      for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;; localObject = ajjy.a(2131650392))
      {
        paramqaq.D.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (nbe.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
          {
            localObject = ajjy.a(2131650422);
            paramqaq.D.setTextColor(-1);
            paramqaq.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramqaq.D.setText((CharSequence)localObject);
            return;
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {}
          for (String str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;; str = ajjy.a(2131650390))
          {
            paramqaq.D.setTextColor(-1);
            localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842249);
            paramqaq.D.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
            paramqaq.D.setText(str);
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
          }
        }
      }
      else
      {
        if (!c()) {
          break label360;
        }
        localObject = ajjy.a(2131650389);
        paramqaq.D.setTextColor(Color.parseColor("#262626"));
        paramqaq.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;; localObject = ajjy.a(2131650364))
    {
      paramqaq.D.setTextColor(-1);
      break;
    }
  }
  
  private void c(qaq paramqaq)
  {
    if ((paramqaq != null) && (paramqaq.s != null)) {
      paramqaq.s.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Pxh != null)) {
      try
      {
        String str = this.jdField_a_of_type_Pxh.d;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = bccu.a().c(str);
          if ((naw.a(this.jdField_a_of_type_AndroidAppActivity, str)) && (localDownloadInfo != null) && (localDownloadInfo.a() == 4))
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
    Object localObject = this.jdField_a_of_type_Pxh.d;
    int i = nbe.ad;
    i = nbe.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bady.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nbe.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (naw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Pxh))
    {
      localObject = bccu.a().c(this.jdField_a_of_type_Pxh.d);
      bccu.a().c((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nbe.ad;
        i = nbe.e;
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
    if (this.jdField_a_of_type_Pxh == null) {}
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
          localObject = this.jdField_a_of_type_Pxh.d;
          if (bady.a(BaseApplicationImpl.getContext(), (String)localObject))
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
    } while ((this.jdField_a_of_type_Pxh == null) || (this.jdField_a_of_type_Nay == null));
    this.jdField_a_of_type_Nay.a(this.jdField_a_of_type_Pxh);
    return;
    int i = nbe.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nav.a(this.jdField_a_of_type_Pxh, e()))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nbe.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
    {
      i = nbe.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Qaq.D.setVisibility(8);
    this.jdField_a_of_type_Qaq.E.setVisibility(0);
    this.jdField_a_of_type_Qaq.E.setText(ajjy.a(2131650425) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Qaq.E.setTextColor(Color.parseColor("#262626"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Qaq.D.setClickable(false);
      this.jdField_a_of_type_Qaq.s.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qaq.E.setClickable(false);
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      return;
      this.jdField_a_of_type_Qaq.D.setClickable(true);
      this.jdField_a_of_type_Qaq.s.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Qce = new qce(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.t));
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
      this.jdField_a_of_type_Qaq.D.setClickable(false);
      this.jdField_a_of_type_Qaq.s.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qaq.E.setClickable(false);
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      return;
      this.jdField_a_of_type_Qaq.D.setClickable(true);
      this.jdField_a_of_type_Qaq.s.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Pxh != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Pxh.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Qaq.D.setClickable(true);
      this.jdField_a_of_type_Qaq.s.setClickable(true);
      this.jdField_a_of_type_Qaq.E.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Qaq.D.setClickable(false);
      this.jdField_a_of_type_Qaq.s.setClickable(false);
      this.jdField_a_of_type_Qaq.E.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Qbz.a();
  }
  
  public qbz a()
  {
    return this.jdField_a_of_type_Qbz;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nay != null) {
      this.jdField_a_of_type_Nay.b();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = nbe.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)))
    {
      paramInt = nbe.e;
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
      return;
    case 3: 
      m();
      this.jdField_a_of_type_Qaq.D.setVisibility(8);
      this.jdField_a_of_type_Qaq.E.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setTextColor(Color.parseColor("#262626"));
      return;
    case 5: 
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.D.setText(ajjy.a(2131650376));
      this.jdField_a_of_type_Qaq.D.setTextColor(-1);
      this.jdField_a_of_type_Qaq.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      a(paramInt1);
      return;
    case 1: 
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.D.setText(ajjy.a(2131650354));
      this.jdField_a_of_type_Qaq.D.setTextColor(-1);
      this.jdField_a_of_type_Qaq.D.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      return;
    case 4: 
      this.jdField_a_of_type_Qaq.D.setVisibility(8);
      this.jdField_a_of_type_Qaq.E.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setText(ajjy.a(2131650445));
      this.jdField_a_of_type_Qaq.E.setTextColor(-1);
      return;
    case 6: 
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, ajjy.a(2131650435), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) && (this.jdField_a_of_type_Qce != null) && (this.jdField_a_of_type_Qce.a == paramLong)) {
      this.jdField_a_of_type_Qaq.D.post(new VideoFeedsGameAdComManager.1(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Npv != null))
    {
      this.jdField_a_of_type_Npv.a(paramConfiguration);
      this.jdField_a_of_type_Npv.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, qaq paramqaq)
  {
    if (paramqaq.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramqaq.s != null) && (paramqaq.s.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
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
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramqaq);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        paramqaq = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            paramqaq.append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        paramqaq = paramqaq.toString();
        if (TextUtils.isEmpty(paramqaq)) {}
        for (paramqaq = "";; paramqaq = paramqaq.substring(0, paramqaq.length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = paramqaq;
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Qbz.a();
          paramqaq = "";
          paramVideoInfo = paramqaq;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramqaq;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramqaq = new HashMap();
          a(nbe.jdField_b_of_type_Int, paramqaq);
          ndn.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(nbe.ad), String.valueOf(nbe.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramqaq.s == null) || (paramqaq.s.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramqaq.s.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) {
      this.jdField_a_of_type_Pxh = pxh.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(qaq paramqaq)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramqaq);
  }
  
  public void a(boolean paramBoolean)
  {
    npd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new qcc(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(qaq paramqaq, boolean paramBoolean)
  {
    if ((paramqaq.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramqaq.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1))
    {
      a(paramqaq.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramqaq.a.a, paramqaq);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Qbz.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Nay != null) && (this.jdField_a_of_type_Pxh != null)) {
      this.jdField_a_of_type_Nay.b(this.jdField_a_of_type_Pxh);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    npd.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new qcd(this, paramBoolean));
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
    if ((this.jdField_a_of_type_Nay != null) && (this.jdField_a_of_type_Pxh != null)) {
      this.jdField_a_of_type_Nay.a(this.jdField_a_of_type_Pxh);
    }
    if (this.jdField_a_of_type_Qaq.E != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Qce == null) {
      return false;
    }
    return nnx.a(null, this.jdField_a_of_type_Qce.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Pxh != null) && (this.jdField_a_of_type_Nay != null)) {
      this.jdField_a_of_type_Nay.e(this.jdField_a_of_type_Pxh);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Pxh != null) && (this.jdField_a_of_type_Nay != null)) {
      this.jdField_a_of_type_Nay.a(this.jdField_a_of_type_Pxh, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.2(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Pxh != null))
    {
      if ((this.jdField_a_of_type_Pxh.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Pxh.d))) {
        npj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Pxh.d);
      }
    }
    else {
      return;
    }
    rvb.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Qaq == null) {
      return;
    }
    this.jdField_a_of_type_Qaq.E.setVisibility(8);
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
      if (this.jdField_a_of_type_Pxh != null)
      {
        bool1 = bady.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Pxh.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Qaq.D.setVisibility(8);
        this.jdField_a_of_type_Qaq.E.setVisibility(0);
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
      this.jdField_a_of_type_Qaq.D.setVisibility(0);
      this.jdField_a_of_type_Qaq.E.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Pxh != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (qaq)paramView.getTag();
    int i = nbe.ad;
    int j = nbe.jdField_a_of_type_Int;
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
      ndn.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(nbe.ad), String.valueOf(nbe.jdField_a_of_type_Int), paramView, b());
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
      } while (this.jdField_a_of_type_Pxh == null);
      if (!a(j, (HashMap)localObject, false)) {
        if (yox.a())
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
              if (this.jdField_a_of_type_Pxh == null) {
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
                i = nbe.e;
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
                i = nbe.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          npj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          npa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.o, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qca
 * JD-Core Version:    0.7.0.1
 */