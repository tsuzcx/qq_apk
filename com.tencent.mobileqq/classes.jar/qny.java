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

public class qny
  implements View.OnClickListener, obk
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + qny.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nlz jdField_a_of_type_Nlz;
  private obg jdField_a_of_type_Obg;
  private qjf jdField_a_of_type_Qjf;
  private qls jdField_a_of_type_Qls;
  private qms jdField_a_of_type_Qms;
  private qnx jdField_a_of_type_Qnx;
  private qoc jdField_a_of_type_Qoc;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  public qny(QQAppInterface paramQQAppInterface, Activity paramActivity, qls paramqls, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_Qnx = new qnx(paramQQAppInterface);
    this.jdField_a_of_type_Int = bawz.a(paramActivity, 3.0F);
    this.jdField_a_of_type_Qls = paramqls;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Nlz = new nlz(paramActivity, true, paramVideoFeedsRecyclerView);
  }
  
  private void a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    nmf.a(new nyg().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(nmf.ad).c(nmf.ao).d(nmf.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a());
  }
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, qms paramqms)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Qms = paramqms;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramqms.q == null) && ((paramqms instanceof qmr)))
    {
      paramqms.q = ((ViewGroup)((ViewStub)paramqms.o.findViewById(2131378985)).inflate());
      paramqms.e = ((URLImageView)paramqms.q.findViewById(2131366907));
      paramqms.H = ((TextView)paramqms.q.findViewById(2131366910));
      paramqms.I = ((TextView)paramqms.q.findViewById(2131366909));
      paramqms.J = ((TextView)paramqms.q.findViewById(2131366908));
      paramqms.K = ((TextView)paramqms.q.findViewById(2131366906));
    }
    if (paramqms.q != null)
    {
      paramqms.q.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(bavi.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(bavi.j);
      paramqms.e.setImageDrawable(localURLDrawable);
      paramqms.H.setText(paramGameAdComData.jdField_c_of_type_JavaLangString);
      paramqms.I.setText(paramGameAdComData.i);
      if (oat.a()) {
        paramqms.I.setTextColor(Color.parseColor("#80000000"));
      }
      paramqms.q.setTag(paramqms);
      paramqms.J.setTag(paramqms);
      paramqms.K.setTag(paramqms);
      paramqms.q.setOnClickListener(this);
      paramqms.J.setOnClickListener(this);
      paramqms.K.setOnClickListener(this);
      paramqms.q.setTag(2131379208, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      i();
      b(paramqms);
      qol.a(paramqms.q, 200);
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
    if (bbfd.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qjf.d))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = nmf.e;
      }
      a(paramInt, paramHashMap);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Qms.J.setVisibility(0);
        this.jdField_a_of_type_Qms.K.setVisibility(8);
      }
    }
    do
    {
      do
      {
        return true;
        if (!nlx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjf)) {
          break;
        }
        DownloadInfo localDownloadInfo = bdgv.a().c(this.jdField_a_of_type_Qjf.d);
        bdgv.a().a(localDownloadInfo);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
        {
          paramHashMap.put("download_state", "3");
          paramInt = nmf.e;
        }
        a(paramInt, paramHashMap);
      } while (!paramBoolean);
      this.jdField_a_of_type_Qms.J.setVisibility(0);
      this.jdField_a_of_type_Qms.K.setVisibility(8);
      return true;
      if (!nlw.a(this.jdField_a_of_type_Qjf, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int)) {
        break;
      }
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = nmf.e;
      }
      a(paramInt, paramHashMap);
    } while (!paramBoolean);
    this.jdField_a_of_type_Qms.J.setVisibility(0);
    this.jdField_a_of_type_Qms.K.setVisibility(8);
    return true;
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (oau.a(this.jdField_a_of_type_Qnx)) {
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
  
  private void b(qms paramqms)
  {
    Object localObject = ajyc.a(2131716250);
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
    bool = oat.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131718455);
        paramqms.J.setTextColor(Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          paramqms.J.setTextColor(Color.parseColor("#80000000"));
          localObject = str;
        }
        paramqms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    for (;;)
    {
      paramqms.J.setText((CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = ajyc.a(2131716183))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;
        }
        paramqms.J.setTextColor(-1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (nmf.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = ajyc.a(2131716213))
          {
            paramqms.J.setTextColor(-1);
            paramqms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            paramqms.J.setText((CharSequence)localObject);
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
          paramqms.J.setTextColor(-1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130842332);
          paramqms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          paramqms.J.setText(str);
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
          str = ajyc.a(2131716181);
          break label273;
          label387:
          paramqms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = ajyc.a(2131716180);
      paramqms.J.setTextColor(Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        paramqms.J.setTextColor(Color.parseColor("#80000000"));
        localObject = str;
      }
      paramqms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u;; localObject = ajyc.a(2131716155))
    {
      paramqms.J.setTextColor(-1);
      break;
    }
  }
  
  private void c(qms paramqms)
  {
    if ((paramqms != null) && (paramqms.q != null)) {
      paramqms.q.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_Qjf != null)) {
      try
      {
        String str = this.jdField_a_of_type_Qjf.d;
        if (!TextUtils.isEmpty(str))
        {
          DownloadInfo localDownloadInfo = bdgv.a().c(str);
          if ((nlx.a(this.jdField_a_of_type_AndroidAppActivity, str)) && (localDownloadInfo != null) && (localDownloadInfo.a() == 4))
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
    Object localObject = this.jdField_a_of_type_Qjf.d;
    int i = nmf.ad;
    i = nmf.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if (bbfd.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nmf.e;
        localHashMap.put("download_state", "5");
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, localHashMap);
      return true;
    }
    if (nlx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjf))
    {
      localObject = bdgv.a().c(this.jdField_a_of_type_Qjf.d);
      bdgv.a().a((DownloadInfo)localObject);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nmf.ad;
        i = nmf.e;
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
    if (this.jdField_a_of_type_Qjf == null) {}
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
          localObject = this.jdField_a_of_type_Qjf.d;
          if (bbfd.a(BaseApplicationImpl.getContext(), (String)localObject))
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
    } while ((this.jdField_a_of_type_Qjf == null) || (this.jdField_a_of_type_Nlz == null));
    this.jdField_a_of_type_Nlz.a(this.jdField_a_of_type_Qjf);
    return;
    int i = nmf.jdField_a_of_type_Int;
    Object localObject = new HashMap();
    if (nlw.a(this.jdField_a_of_type_Qjf, e()))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
      {
        i = nmf.e;
        ((HashMap)localObject).put("download_state", "3");
      }
      a(i, (HashMap)localObject);
      return;
    }
    c();
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r))
    {
      i = nmf.e;
      ((HashMap)localObject).put("download_state", "1");
    }
    a(i, (HashMap)localObject);
  }
  
  private void m()
  {
    this.jdField_a_of_type_Qms.J.setVisibility(8);
    this.jdField_a_of_type_Qms.K.setVisibility(0);
    if (!oat.a())
    {
      this.jdField_a_of_type_Qms.K.setText(ajyc.a(2131716216) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      this.jdField_a_of_type_Qms.K.setTextColor(Color.parseColor("#262626"));
      return;
    }
    this.jdField_a_of_type_Qms.K.setText(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    this.jdField_a_of_type_Qms.K.setTextColor(Color.parseColor("#80000000"));
  }
  
  private void n()
  {
    if (c())
    {
      this.jdField_a_of_type_Qms.J.setClickable(false);
      this.jdField_a_of_type_Qms.q.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qms.K.setClickable(false);
      this.jdField_a_of_type_Qms.J.setVisibility(0);
      this.jdField_a_of_type_Qms.K.setVisibility(8);
      return;
      this.jdField_a_of_type_Qms.J.setClickable(true);
      this.jdField_a_of_type_Qms.q.setClickable(true);
    }
  }
  
  private void o()
  {
    try
    {
      this.jdField_a_of_type_Qoc = new qoc(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.t));
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
      this.jdField_a_of_type_Qms.J.setClickable(false);
      this.jdField_a_of_type_Qms.q.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qms.K.setClickable(false);
      this.jdField_a_of_type_Qms.J.setVisibility(0);
      this.jdField_a_of_type_Qms.K.setVisibility(8);
      return;
      this.jdField_a_of_type_Qms.J.setClickable(true);
      this.jdField_a_of_type_Qms.q.setClickable(true);
    }
  }
  
  private void q()
  {
    if ((a()) && (this.jdField_a_of_type_Qjf != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjf.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Qms.J.setClickable(true);
      this.jdField_a_of_type_Qms.q.setClickable(true);
      this.jdField_a_of_type_Qms.K.setClickable(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Qms.J.setVisibility(0);
      this.jdField_a_of_type_Qms.K.setVisibility(8);
      j();
      return;
      this.jdField_a_of_type_Qms.J.setClickable(false);
      this.jdField_a_of_type_Qms.q.setClickable(false);
      this.jdField_a_of_type_Qms.K.setClickable(false);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Qnx.a();
  }
  
  public qnx a()
  {
    return this.jdField_a_of_type_Qnx;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_Nlz != null) {
      this.jdField_a_of_type_Nlz.b();
    }
  }
  
  protected void a(int paramInt)
  {
    int i = nmf.jdField_a_of_type_Int;
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)))
    {
      paramInt = nmf.e;
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
          this.jdField_a_of_type_Qms.J.setVisibility(8);
          this.jdField_a_of_type_Qms.K.setVisibility(0);
          this.jdField_a_of_type_Qms.K.setTextColor(Color.parseColor("#262626"));
        } while (!oat.a());
        this.jdField_a_of_type_Qms.K.setTextColor(Color.parseColor("#80000000"));
        return;
        this.jdField_a_of_type_Qms.J.setVisibility(0);
        this.jdField_a_of_type_Qms.J.setText(ajyc.a(2131716167));
        if (oat.a()) {
          this.jdField_a_of_type_Qms.J.setText("安装");
        }
        this.jdField_a_of_type_Qms.J.setTextColor(-1);
        this.jdField_a_of_type_Qms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Qms.K.setVisibility(8);
        a(paramInt1);
        return;
        this.jdField_a_of_type_Qms.J.setVisibility(0);
        this.jdField_a_of_type_Qms.J.setText(ajyc.a(2131716145));
        if (oat.a()) {
          this.jdField_a_of_type_Qms.J.setText("打开");
        }
        this.jdField_a_of_type_Qms.J.setTextColor(-1);
        this.jdField_a_of_type_Qms.J.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_Qms.K.setVisibility(8);
        return;
        this.jdField_a_of_type_Qms.J.setVisibility(8);
        this.jdField_a_of_type_Qms.K.setVisibility(0);
        this.jdField_a_of_type_Qms.K.setText(ajyc.a(2131716236));
        this.jdField_a_of_type_Qms.K.setTextColor(-1);
      } while (!oat.a());
      this.jdField_a_of_type_Qms.K.setText("继续");
      this.jdField_a_of_type_Qms.K.setTextColor(Color.parseColor("#80000000"));
      return;
    case 6: 
      this.jdField_a_of_type_Qms.J.setVisibility(0);
      this.jdField_a_of_type_Qms.K.setVisibility(8);
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, ajyc.a(2131716226), 0).a();
      return;
    }
    l();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) && (this.jdField_a_of_type_Qoc != null) && (this.jdField_a_of_type_Qoc.a == paramLong)) {
      this.jdField_a_of_type_Qms.J.post(new VideoFeedsGameAdComManager.1(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_Obg != null))
    {
      this.jdField_a_of_type_Obg.a(paramConfiguration);
      this.jdField_a_of_type_Obg.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, qms paramqms)
  {
    if (paramqms.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramqms.q != null) && (paramqms.q.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
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
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramqms);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        paramqms = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            paramqms.append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        paramqms = paramqms.toString();
        if (TextUtils.isEmpty(paramqms)) {}
        for (paramqms = "";; paramqms = paramqms.substring(0, paramqms.length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = paramqms;
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Qnx.a();
          paramqms = "";
          paramVideoInfo = paramqms;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramqms;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
              paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
            }
          }
          paramqms = new HashMap();
          a(nmf.jdField_b_of_type_Int, paramqms);
          noo.a(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(nmf.ad), String.valueOf(nmf.jdField_a_of_type_Int), paramVideoInfo, b());
          return;
        }
      }
    } while ((paramqms.q == null) || (paramqms.q.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramqms.q.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.r)) {
      this.jdField_a_of_type_Qjf = qjf.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(qms paramqms)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramqms);
  }
  
  public void a(boolean paramBoolean)
  {
    oao.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.a.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new qoa(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(qms paramqms, boolean paramBoolean)
  {
    if ((paramqms.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramqms.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1))
    {
      a(paramqms.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramqms.a.a, paramqms);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Qnx.b();
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Nlz != null) && (this.jdField_a_of_type_Qjf != null)) {
      this.jdField_a_of_type_Nlz.b(this.jdField_a_of_type_Qjf);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    oao.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new qob(this, paramBoolean));
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
    if ((this.jdField_a_of_type_Nlz != null) && (this.jdField_a_of_type_Qjf != null)) {
      this.jdField_a_of_type_Nlz.a(this.jdField_a_of_type_Qjf);
    }
    if (this.jdField_a_of_type_Qms.K != null) {
      m();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_Qoc == null) {
      return false;
    }
    return nzi.a(null, this.jdField_a_of_type_Qoc.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Qjf != null) && (this.jdField_a_of_type_Nlz != null)) {
      this.jdField_a_of_type_Nlz.e(this.jdField_a_of_type_Qjf);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  protected void e()
  {
    if ((this.jdField_a_of_type_Qjf != null) && (this.jdField_a_of_type_Nlz != null)) {
      this.jdField_a_of_type_Nlz.a(this.jdField_a_of_type_Qjf, true);
    }
  }
  
  public void f()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.2(this));
  }
  
  protected void g()
  {
    if ((a()) && (this.jdField_a_of_type_Qjf != null))
    {
      if ((this.jdField_a_of_type_Qjf.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_Qjf.d))) {
        oau.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Qjf.d);
      }
    }
    else {
      return;
    }
    sht.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void i()
  {
    if (this.jdField_a_of_type_Qms == null) {
      return;
    }
    this.jdField_a_of_type_Qms.K.setVisibility(8);
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
      if (this.jdField_a_of_type_Qjf != null)
      {
        bool1 = bbfd.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Qjf.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        this.jdField_a_of_type_Qms.J.setVisibility(8);
        this.jdField_a_of_type_Qms.K.setVisibility(0);
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
      this.jdField_a_of_type_Qms.J.setVisibility(0);
      this.jdField_a_of_type_Qms.K.setVisibility(8);
    }
  }
  
  public void k()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_Qjf != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (qms)paramView.getTag();
    int i = nmf.ad;
    int j = nmf.jdField_a_of_type_Int;
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
      noo.a(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(nmf.ad), String.valueOf(nmf.jdField_a_of_type_Int), paramView, b());
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
      } while (this.jdField_a_of_type_Qjf == null);
      if (!a(j, (HashMap)localObject, false)) {
        if (yyq.a())
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
              if (this.jdField_a_of_type_Qjf == null) {
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
                i = nmf.e;
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
                i = nmf.e;
              }
            }
          }
          this.jdField_b_of_type_Boolean = false;
          oau.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          oal.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.o, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qny
 * JD-Core Version:    0.7.0.1
 */