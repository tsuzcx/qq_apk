import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.4;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.5;
import com.tencent.biz.pubaccount.readinjoy.video.TopicShareHelper.6;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class qko
  implements AdapterView.OnItemClickListener
{
  public static String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bcpq jdField_a_of_type_Bcpq;
  private bfol jdField_a_of_type_Bfol;
  private ChannelInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private qvc jdField_a_of_type_Qvc;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://kandian.qq.com/mqq/html/topicvideo.html?_wv=3&_bid=2378&videotopicid=";
  }
  
  public qko(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
      paramActivity = bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true).getString("readinjoy_social_weburl_topicvideo", "");
      if (!TextUtils.isEmpty(paramActivity))
      {
        jdField_a_of_type_JavaLangString = paramActivity;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "update SHARE_URL_PREF from config, config=" + paramActivity);
        }
      }
    }
  }
  
  private View a()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559044, null);
    float f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131375662);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131375663);
    GridView localGridView2 = (GridView)localView.findViewById(2131367168);
    GridView localGridView1 = (GridView)localView.findViewById(2131367169);
    Object localObject1 = (TextView)localView.findViewById(2131361927);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690596);
    ((TextView)localObject1).setOnClickListener(new qkq(this));
    this.jdField_a_of_type_Bfol.setOnDismissListener(new qkr(this));
    if (Build.VERSION.SDK_INT >= 9)
    {
      localElasticHorScrView1.setOverScrollMode(2);
      localElasticHorScrView2.setOverScrollMode(2);
    }
    localGridView1.setSmoothScrollbarEnabled(false);
    localObject2 = a();
    if (localObject2.length > 0)
    {
      localObject1 = localObject2[0];
      if (localObject2.length <= 1) {
        break label430;
      }
    }
    label430:
    for (localObject2 = localObject2[1];; localObject2 = new ArrayList(0))
    {
      int i = ((List)localObject1).size();
      localGridView2.setNumColumns(i);
      ViewGroup.LayoutParams localLayoutParams = localGridView2.getLayoutParams();
      localLayoutParams.width = ((int)(((i - 1) * 10 + i * 75 + 3) * f));
      localGridView2.setLayoutParams(localLayoutParams);
      localGridView2.setAdapter(new nnd(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f * (j * 75 + (j - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new nnd(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
      localGridView1.setSelector(new ColorDrawable(0));
      localGridView1.setOnItemClickListener(this);
      localView.post(new TopicShareHelper.4(this, localElasticHorScrView1, i, localElasticHorScrView2, ((ViewGroup.LayoutParams)localObject1).width));
      return localView;
      localObject1 = new ArrayList(0);
      break;
    }
  }
  
  public static String a(ChannelInfo paramChannelInfo, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 6;
    }
    try
    {
      for (;;)
      {
        String str1 = URLEncoder.encode(paramChannelInfo.mChannelName, "UTF-8");
        return jdField_a_of_type_JavaLangString + paramChannelInfo.mChannelID + "&topicname=" + str1 + "&sourcefrom=" + paramInt;
        paramInt = 0;
        continue;
        paramInt = 1;
        continue;
        paramInt = 2;
        continue;
        paramInt = 3;
        continue;
        paramInt = 4;
        continue;
        paramInt = 5;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        String str2 = "";
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina start!");
    }
    paramString2 = this.jdField_a_of_type_AndroidAppActivity;
    if (this.jdField_a_of_type_Bcpq == null) {
      this.jdField_a_of_type_Bcpq = new bcpq(this.jdField_a_of_type_AndroidAppActivity, paramString2.getResources().getDimensionPixelSize(2131298865));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_Bcpq != null) && (this.jdField_a_of_type_Bcpq.isShowing())) {
        this.jdField_a_of_type_Bcpq.dismiss();
      }
      bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719476, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Bcpq.isShowing())
      {
        this.jdField_a_of_type_Bcpq.c(2131694099);
        this.jdField_a_of_type_Bcpq.show();
      }
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
        }
        ThreadManager.executeOnSubThread(new TopicShareHelper.6(this, paramString4, paramString1, paramString3, (ApplicationInfo)localObject, paramString2));
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label250;
          }
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina installSinaWeibo:false");
          try
          {
            paramString1 = URLEncoder.encode(paramString1, "UTF-8");
            paramString1 = "http://v.t.sina.com.cn/share/share.php?" + "title=" + paramString1;
            paramString3 = URLEncoder.encode(paramString3, "UTF-8");
            paramString1 = paramString1 + "&url=" + paramString3;
            paramString3 = URLEncoder.encode(paramString4, "UTF-8");
            paramString1 = paramString1 + "&pic=" + paramString3;
            paramString1 = paramString1 + "&_wv=3";
            paramString3 = new Intent(paramString2, QQBrowserActivity.class);
            paramString3.putExtra("url", paramString1);
            paramString2.startActivity(paramString3);
            if (!QLog.isColorLevel()) {
              break label414;
            }
            QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina start webview!");
            if ((this.jdField_a_of_type_Bcpq == null) || (!this.jdField_a_of_type_Bcpq.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_Bcpq.dismiss();
          }
          catch (Exception paramString1)
          {
            bcpw.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131719476, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298865));
            paramString1.printStackTrace();
            if ((this.jdField_a_of_type_Bcpq == null) || (!this.jdField_a_of_type_Bcpq.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_Bcpq.dismiss();
          }
          finally
          {
            if ((this.jdField_a_of_type_Bcpq == null) || (!this.jdField_a_of_type_Bcpq.isShowing())) {
              break label527;
            }
            this.jdField_a_of_type_Bcpq.dismiss();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina end!");
  }
  
  private List<nnc>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new nnc();
    ((nnc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696695);
    ((nnc)localObject).jdField_a_of_type_Int = 2130838754;
    ((nnc)localObject).jdField_a_of_type_Boolean = true;
    ((nnc)localObject).jdField_b_of_type_Int = 2;
    ((nnc)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nnc();
    ((nnc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696708);
    ((nnc)localObject).jdField_a_of_type_Int = 2130838755;
    ((nnc)localObject).jdField_a_of_type_Boolean = true;
    ((nnc)localObject).jdField_b_of_type_Int = 3;
    ((nnc)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nnc();
    ((nnc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696715);
    ((nnc)localObject).jdField_a_of_type_Int = 2130838758;
    ((nnc)localObject).jdField_b_of_type_Int = 9;
    ((nnc)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nnc();
    ((nnc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696698);
    ((nnc)localObject).jdField_a_of_type_Int = 2130838752;
    ((nnc)localObject).jdField_b_of_type_Int = 10;
    ((nnc)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nnc();
    ((nnc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696712);
    ((nnc)localObject).jdField_a_of_type_Int = 2130838757;
    ((nnc)localObject).jdField_b_of_type_Int = 12;
    ((nnc)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new nnc();
    ((nnc)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696692);
    ((nnc)localObject).jdField_a_of_type_Boolean = true;
    ((nnc)localObject).jdField_a_of_type_Int = 2130842126;
    ((nnc)localObject).jdField_b_of_type_Int = 4;
    ((nnc)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    nnc localnnc = new nnc();
    localnnc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696687);
    localnnc.jdField_a_of_type_Int = 2130838750;
    localnnc.jdField_a_of_type_Boolean = true;
    localnnc.jdField_b_of_type_Int = 1;
    localnnc.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localnnc);
    localnnc = new nnc();
    localnnc.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696693);
    localnnc.jdField_a_of_type_Int = 2130842116;
    localnnc.jdField_a_of_type_Boolean = true;
    localnnc.jdField_b_of_type_Int = 11;
    localnnc.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localnnc);
    return (List[])new ArrayList[] { localArrayList, localObject };
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    do
    {
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mHeaderPicUrl, null, null);
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = ((RegionDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).getBitmap();
          return;
        }
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.readinjoy.video.TopicShareHelper", 2, "initTopicThumbBitmap() URLDrawable.getDrawable ERROR, RETURN");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentImageURLDrawable == null);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new qkp(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfol == null) {
      this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    View localView = a();
    this.jdField_a_of_type_Bfol.a(localView, null);
    try
    {
      if (!this.jdField_a_of_type_Bfol.isShowing())
      {
        this.jdField_a_of_type_Bfol.show();
        b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ChannelInfo paramChannelInfo, Intent paramIntent, qvc paramqvc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo = paramChannelInfo;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Qvc = paramqvc;
    a();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b = true;
    paramAdapterView = paramView.getTag();
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder().append("onItemClick, tag = ");
      if (paramAdapterView == null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, bool);
      if (paramAdapterView != null) {
        break;
      }
      return;
    }
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
    int j = ((nne)paramAdapterView).a.jdField_b_of_type_Int;
    int i = 3;
    if (j == 2)
    {
      this.jdField_a_of_type_Boolean = false;
      paramInt = 0;
      aqbc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, 21);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new TopicShareHelper.5(this, paramInt + ""));
      return;
      if (j == 3)
      {
        this.jdField_a_of_type_Boolean = false;
        paramInt = 1;
        paramAdapterView = new Bundle();
        paramAdapterView.putString("title", ajyc.a(2131715031) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelName + ajyc.a(2131715028));
        paramAdapterView.putString("detail_url", a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 1));
        paramView = new ArrayList(1);
        paramView.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mHeaderPicUrl);
        paramAdapterView.putStringArrayList("image_url", paramView);
        paramAdapterView.putLong("req_share_id", 0L);
        bgyu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, paramAdapterView, null);
        continue;
      }
      if ((j == 9) || (j == 10))
      {
        this.jdField_a_of_type_Boolean = false;
        label331:
        Object localObject;
        String str;
        Bitmap localBitmap;
        if (j == 9)
        {
          paramAdapterView = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 2);
          paramInt = 2;
          localObject = new StringBuilder();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mFollowNum > 0) {
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mFollowNum).append("人正在关注");
          }
          paramView = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
          str = ajyc.a(2131715030) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelName + ajyc.a(2131715027);
          localObject = ((StringBuilder)localObject).toString();
          localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
          if (j != 9) {
            break label472;
          }
        }
        label472:
        for (bool = true;; bool = false)
        {
          npy.a(paramView, str, (String)localObject, paramAdapterView, localBitmap, bool, null, null);
          break;
          paramAdapterView = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 3);
          paramInt = 4;
          break label331;
        }
      }
      if (j == 12)
      {
        this.jdField_a_of_type_Boolean = false;
        paramInt = 5;
        a(ajyc.a(2131715032) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelName + ajyc.a(2131715029), null, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 4), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mHeaderPicUrl);
        continue;
      }
      if (j == 4)
      {
        this.jdField_a_of_type_Boolean = false;
        paramAdapterView = new Intent("android.intent.action.VIEW", Uri.parse(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6)));
        paramAdapterView.putExtra("big_brother_source_key", onk.f(0));
        paramAdapterView.putExtra("normal", true);
        try
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramAdapterView);
          paramInt = i;
        }
        catch (ActivityNotFoundException paramAdapterView)
        {
          wim.a(1, 2131695572);
          paramInt = i;
        }
        continue;
      }
      if (j == 6)
      {
        paramInt = 6;
        paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        bgpd.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6)).c(paramAdapterView).b(this.jdField_a_of_type_AndroidAppActivity, paramAdapterView, 101, null);
        continue;
      }
      if (j == 1)
      {
        paramAdapterView = this.jdField_a_of_type_AndroidContentContext;
        paramView = this.jdField_a_of_type_AndroidContentContext;
        ((ClipboardManager)paramAdapterView.getSystemService("clipboard")).setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6));
        wim.a(2, 2131691309);
        paramInt = i;
        continue;
      }
      paramInt = i;
      if (j != 11) {
        continue;
      }
      this.jdField_a_of_type_Boolean = false;
      paramView = null;
      try
      {
        paramAdapterView = URLEncoder.encode(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6), "UTF-8");
        paramAdapterView = "https://post.mp.qq.com/jubao/index?_wv=3&url=" + paramAdapterView + "&type=5&key=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelID;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "click jubao btn, reportUrl:" + paramAdapterView);
        }
        paramView = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        paramView.putExtra("url", paramAdapterView);
        paramView.putExtra("hide_more_button", true);
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramView);
        paramInt = i;
      }
      catch (UnsupportedEncodingException paramAdapterView)
      {
        for (;;)
        {
          paramAdapterView = paramView;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "encode url failed, because UTF-8 is unknown");
            paramAdapterView = paramView;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qko
 * JD-Core Version:    0.7.0.1
 */