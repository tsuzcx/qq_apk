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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneShareManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class sga
  implements AdapterView.OnItemClickListener
{
  public static String a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private bisl jdField_a_of_type_Bisl;
  private bkzi jdField_a_of_type_Bkzi;
  private ChannelInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private sqc jdField_a_of_type_Sqc;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://kandian.qq.com/mqq/html/topicvideo.html?_wv=3&_bid=2378&videotopicid=";
  }
  
  public sga(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    paramActivity = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramActivity instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramActivity);
      paramActivity = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, true).getString("readinjoy_social_weburl_topicvideo", "");
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
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559189, null);
    float f = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density;
    ElasticHorScrView localElasticHorScrView1 = (ElasticHorScrView)localView.findViewById(2131377144);
    ElasticHorScrView localElasticHorScrView2 = (ElasticHorScrView)localView.findViewById(2131377145);
    GridView localGridView2 = (GridView)localView.findViewById(2131367851);
    GridView localGridView1 = (GridView)localView.findViewById(2131367852);
    Object localObject1 = (TextView)localView.findViewById(2131361985);
    Object localObject2 = (LinearLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
    ((LinearLayout.LayoutParams)localObject2).topMargin = ((int)(13.0F * f));
    ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TextView)localObject1).setText(2131690697);
    ((TextView)localObject1).setOnClickListener(new sgc(this));
    this.jdField_a_of_type_Bkzi.setOnDismissListener(new sgd(this));
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
      localGridView2.setAdapter(new ojs(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject1));
      localGridView2.setSelector(new ColorDrawable(0));
      localGridView2.setOnItemClickListener(this);
      i = localLayoutParams.width;
      int j = ((List)localObject2).size();
      localObject1 = localGridView1.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = ((int)(f * (j * 75 + (j - 1) * 10 + 3)));
      localGridView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localGridView1.setNumColumns(j);
      localGridView1.setAdapter(new ojs(this.jdField_a_of_type_AndroidAppActivity, 0, (List)localObject2));
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
    if (this.jdField_a_of_type_Bisl == null) {
      this.jdField_a_of_type_Bisl = new bisl(this.jdField_a_of_type_AndroidAppActivity, paramString2.getResources().getDimensionPixelSize(2131299080));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina empty title or share_url");
      }
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131718766, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Bisl.isShowing())
      {
        this.jdField_a_of_type_Bisl.c(2131693769);
        this.jdField_a_of_type_Bisl.show();
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
            paramString1 = "https://service.weibo.com/share/share.php?" + "title=" + paramString1;
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
            if ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_Bisl.dismiss();
          }
          catch (Exception paramString1)
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, 0, 2131718766, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299080));
            paramString1.printStackTrace();
            if ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing())) {
              continue;
            }
            this.jdField_a_of_type_Bisl.dismiss();
          }
          finally
          {
            if ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing())) {
              break label527;
            }
            this.jdField_a_of_type_Bisl.dismiss();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "shareMsgToSina end!");
  }
  
  private List<ojr>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696130);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839146;
    ((ojr)localObject).jdField_a_of_type_Boolean = true;
    ((ojr)localObject).jdField_b_of_type_Int = 2;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696143);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839147;
    ((ojr)localObject).jdField_a_of_type_Boolean = true;
    ((ojr)localObject).jdField_b_of_type_Int = 3;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696150);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839150;
    ((ojr)localObject).jdField_b_of_type_Int = 9;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696133);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839144;
    ((ojr)localObject).jdField_b_of_type_Int = 10;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696147);
    ((ojr)localObject).jdField_a_of_type_Int = 2130839149;
    ((ojr)localObject).jdField_b_of_type_Int = 12;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ojr();
    ((ojr)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696127);
    ((ojr)localObject).jdField_a_of_type_Boolean = true;
    ((ojr)localObject).jdField_a_of_type_Int = 2130842691;
    ((ojr)localObject).jdField_b_of_type_Int = 4;
    ((ojr)localObject).jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localObject);
    localObject = new ArrayList();
    ojr localojr = new ojr();
    localojr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696122);
    localojr.jdField_a_of_type_Int = 2130839142;
    localojr.jdField_a_of_type_Boolean = true;
    localojr.jdField_b_of_type_Int = 1;
    localojr.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localojr);
    localojr = new ojr();
    localojr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131696128);
    localojr.jdField_a_of_type_Int = 2130842681;
    localojr.jdField_a_of_type_Boolean = true;
    localojr.jdField_b_of_type_Int = 11;
    localojr.jdField_b_of_type_JavaLangString = "";
    ((ArrayList)localObject).add(localojr);
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
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(new sgb(this));
    this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bkzi == null) {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_AndroidAppActivity, null));
    }
    View localView = a();
    this.jdField_a_of_type_Bkzi.a(localView, null);
    try
    {
      if (!this.jdField_a_of_type_Bkzi.isShowing())
      {
        this.jdField_a_of_type_Bkzi.show();
        b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(ChannelInfo paramChannelInfo, Intent paramIntent, sqc paramsqc)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo = paramChannelInfo;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Sqc = paramsqc;
    a();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b = true;
    Object localObject1 = paramView.getTag();
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder().append("onItemClick, tag = ");
      if (localObject1 == null) {
        break label73;
      }
    }
    label73:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.readinjoy.video.TopicShareHelper", 2, bool);
      if (localObject1 != null) {
        break;
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
    int k = ((ojt)localObject1).a.jdField_b_of_type_Int;
    int j = 3;
    int i;
    if (k == 2)
    {
      this.jdField_a_of_type_Boolean = false;
      i = 0;
      aupt.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, 21);
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new TopicShareHelper.5(this, i + ""));
      break;
      if (k == 3)
      {
        this.jdField_a_of_type_Boolean = false;
        i = 1;
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("title", anvx.a(2131714410) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelName + anvx.a(2131714407));
        ((Bundle)localObject1).putString("detail_url", a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 1));
        localObject3 = new ArrayList(1);
        ((ArrayList)localObject3).add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mHeaderPicUrl);
        ((Bundle)localObject1).putStringArrayList("image_url", (ArrayList)localObject3);
        ((Bundle)localObject1).putLong("req_share_id", 0L);
        QZoneShareManager.jumpToQzoneShare(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (Bundle)localObject1, null);
        continue;
      }
      if ((k == 9) || (k == 10))
      {
        this.jdField_a_of_type_Boolean = false;
        label364:
        Object localObject4;
        String str2;
        Bitmap localBitmap;
        if (k == 9)
        {
          localObject1 = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 2);
          i = 2;
          localObject4 = new StringBuilder();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mFollowNum > 0) {
            ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mFollowNum).append("人正在关注");
          }
          localObject3 = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
          str2 = anvx.a(2131714409) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelName + anvx.a(2131714406);
          localObject4 = ((StringBuilder)localObject4).toString();
          localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
          if (k != 9) {
            break label511;
          }
        }
        label511:
        for (bool = true;; bool = false)
        {
          omy.a((BaseActivity)localObject3, str2, (String)localObject4, (String)localObject1, localBitmap, bool, null, false, null);
          break;
          localObject1 = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 3);
          i = 4;
          break label364;
        }
      }
      if (k == 12)
      {
        this.jdField_a_of_type_Boolean = false;
        i = 5;
        a(anvx.a(2131714411) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelName + anvx.a(2131714408), null, a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 4), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mHeaderPicUrl);
        continue;
      }
      if (k == 4)
      {
        this.jdField_a_of_type_Boolean = false;
        localObject1 = new Intent("android.intent.action.VIEW", Uri.parse(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6)));
        ((Intent)localObject1).putExtra("big_brother_source_key", pqx.a(0));
        ((Intent)localObject1).putExtra("normal", true);
        try
        {
          this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject1);
          i = j;
        }
        catch (ActivityNotFoundException localActivityNotFoundException)
        {
          znl.a(1, 2131694987);
          i = j;
        }
        continue;
      }
      String str1;
      if (k == 6)
      {
        i = 6;
        str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        bmad.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6)).c(str1).b(this.jdField_a_of_type_AndroidAppActivity, str1, 101, null);
        continue;
      }
      if (k == 1)
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6));
        znl.a(2, 2131691266);
        i = j;
        continue;
      }
      i = j;
      if (k != 11) {
        continue;
      }
      this.jdField_a_of_type_Boolean = false;
      localObject3 = null;
      try
      {
        str1 = URLEncoder.encode(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, 6), "UTF-8");
        str1 = "https://post.mp.qq.com/jubao/index?_wv=3&url=" + str1 + "&type=5&key=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo.mChannelID;
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "click jubao btn, reportUrl:" + str1);
        }
        localObject3 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", str1);
        ((Intent)localObject3).putExtra("hide_more_button", true);
        this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject3);
        i = j;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          Object localObject2 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.readinjoy.video.TopicShareHelper", 2, "encode url failed, because UTF-8 is unknown");
            localObject2 = localObject3;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sga
 * JD-Core Version:    0.7.0.1
 */