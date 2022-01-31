import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class rht
  extends syt
{
  rht(rhf paramrhf) {}
  
  protected boolean a(Integer paramInteger)
  {
    if (rhf.a(this.a) == null) {
      return false;
    }
    VideoInfo localVideoInfo = rhf.a(this.a);
    if (rhf.a(this.a) != null) {
      rhf.a(this.a).a(localVideoInfo);
    }
    Object localObject1 = new StringBuilder();
    Object localObject5 = rhf.a(this.a).a();
    if (!TextUtils.isEmpty(localVideoInfo.jdField_f_of_type_JavaLangString))
    {
      ((StringBuilder)localObject1).append(localVideoInfo.jdField_f_of_type_JavaLangString);
      if (!TextUtils.isEmpty((CharSequence)localObject5)) {
        ((StringBuilder)localObject1).append("&iid=").append((String)localObject5);
      }
    }
    Object localObject6 = ((StringBuilder)localObject1).toString();
    int i;
    int j;
    int k;
    label275:
    int m;
    switch (paramInteger.intValue())
    {
    default: 
      i = 3;
      j = -1;
      k = -1;
      if ((paramInteger.intValue() != 14) && (paramInteger.intValue() != 20) && (paramInteger.intValue() != 12) && (!rhf.e(this.a)))
      {
        localObject5 = new qlw();
        ((qlw)localObject5).jdField_d_of_type_Int = ((int)rhf.a(this.a).a());
        ((qlw)localObject5).e = (localVideoInfo.a() * 1000);
        m = -1;
        if (rhf.a(this.a) != null)
        {
          ((qlw)localObject5).b = rhf.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          m = rhf.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        }
        if (rhf.c(this.a) != 1) {
          break label2990;
        }
        localObject6 = rhf.a(this.a);
        if (rhf.b(this.a) != null)
        {
          localObject1 = rhf.b(this.a).jdField_g_of_type_JavaLangString;
          label445:
          ntd.a((VideoInfo)localObject6, m, 26, -1, (qlw)localObject5, (String)localObject1);
        }
      }
      else
      {
        if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label3044;
        }
        localObject1 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        label485:
        if (rhf.a(this.a) == null) {
          break label3050;
        }
        m = rhf.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        label513:
        if (localVideoInfo.y == null) {
          break label3056;
        }
      }
      break;
    }
    label1582:
    label1639:
    label1769:
    label3050:
    label3056:
    String str;
    for (localObject5 = localVideoInfo.y;; str = "")
    {
      for (;;)
      {
        for (;;)
        {
          rhf.a(this.a, localVideoInfo.j, Integer.toString(i), localVideoInfo.jdField_g_of_type_JavaLangString, (String)localObject1, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.a(), localVideoInfo.jdField_f_of_type_Long, localVideoInfo.o, -1, m, (String)localObject5, false);
          rhf.a(this.a, localVideoInfo, localVideoInfo.j, localVideoInfo.jdField_g_of_type_JavaLangString, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_Long, k, j, false);
          return super.a(paramInteger);
          try
          {
            if (rhf.a(this.a) != null)
            {
              rhf.a(this.a).a(rhf.b(this.a));
              localObject1 = new Intent(rhf.a(this.a), ReadInJoyDeliverBiuActivity.class);
              if ((rhf.a(this.a).jdField_a_of_type_Int == 6) && (rhf.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
                ((Intent)localObject1).putExtra("feedsType", rhf.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
              }
              ((Intent)localObject1).putExtra("ARG_VIDEO_ARTICLE_ID", rhf.a(this.a).jdField_g_of_type_JavaLangString);
              ((Intent)localObject1).putExtra("biu_src", 2);
              ((Intent)localObject1).putExtra("arg_from_type", 8);
              ((Intent)localObject1).putExtra("arg_article_info", rhf.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
              rhf.a(this.a).startActivityForResult((Intent)localObject1, 102);
              rhf.a(this.a).overridePendingTransition(0, 0);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("VideoFeedsShareController", 2, "innerOpenReadInJoyBiuActivity error exception = " + localException1.getMessage());
              }
              rhf.a(this.a).a(false);
            }
          }
          i = 3;
          j = -1;
          k = 0;
          break;
          ((ClipboardManager)rhf.a(this.a).getSystemService("clipboard")).setText((CharSequence)localObject6);
          ybk.a(2, 2131691363);
          i = 3;
          j = 3;
          k = -1;
          break;
          localObject5 = null;
          Object localObject2 = localObject5;
          if (!TextUtils.isEmpty((CharSequence)localObject6)) {}
          try
          {
            localObject2 = URLEncoder.encode((String)localObject6, "UTF-8");
            if (!TextUtils.isEmpty(localVideoInfo.j))
            {
              localObject5 = localVideoInfo.j;
              i = 0;
              if (localVideoInfo.jdField_a_of_type_Int == 6) {
                i = 1;
              }
              localObject2 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + (String)localObject5 + "&uin_type=" + i + "&url=" + (String)localObject2 + "&type=4&key=" + localVideoInfo.jdField_g_of_type_JavaLangString;
              rhf.a(this.a, "click jubao btn, reportUrl:" + (String)localObject2);
              rhf.a(this.a).a(rhf.b(this.a));
              localObject5 = new Intent(rhf.a(this.a), QQBrowserActivity.class);
              ((Intent)localObject5).putExtra("url", (String)localObject2);
              ((Intent)localObject5).putExtra("hide_more_button", true);
              rhf.a(this.a).startActivity((Intent)localObject5);
              i = 3;
              j = 5;
              k = -1;
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              rhf.a(this.a, "encode url failed, because UTF-8 is unknown");
              localObject3 = localObject5;
              continue;
              localObject5 = "0";
            }
          }
        }
        rhf.a(this.a, localVideoInfo);
        i = 0;
        j = -1;
        k = 1;
        break;
        rhf.a(this.a).a(rhf.b(this.a));
        this.a.a.a((String)localObject6 + "&sourcefrom=6");
        i = 3;
        j = -1;
        k = 6;
        break;
        rhf.a(this.a).a(rhf.b(this.a));
        this.a.a.b((String)localObject6 + "&sourcefrom=6");
        i = 3;
        j = -1;
        k = 7;
        break;
        i = 1;
        rhf.a(this.a).a(rhf.b(this.a));
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("title", localVideoInfo.c);
        ((Bundle)localObject3).putString("desc", localVideoInfo.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject3).putString("detail_url", rhf.a((String)localObject6, localVideoInfo) + "&sourcefrom=1");
        localObject5 = new ArrayList(1);
        ((ArrayList)localObject5).add(localVideoInfo.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject5);
        ((Bundle)localObject3).putLong("req_share_id", 0L);
        bjev.a(rhf.a(this.a), rhf.a(this.a), (Bundle)localObject3, null, 10001);
        j = -1;
        k = 2;
        break;
        if (!bdin.g(rhf.a(this.a)))
        {
          QQToast.a(rhf.a(this.a), 0, alud.a(2131716592), 0).a();
          return false;
        }
        rdm.a(rhf.a(this.a), rhf.a(this.a));
        j = 6;
        localVideoInfo.e = true;
        rhf.a(this.a).a(rhf.b(this.a));
        if ((rhf.a(this.a) instanceof VideoFeedsPlayActivity)) {
          ((VideoFeedsPlayActivity)rhf.a(this.a)).d(true);
        }
        localObject3 = localVideoInfo.k;
        localObject5 = new Bundle();
        ((Bundle)localObject5).putInt("videoDuration", localVideoInfo.jdField_d_of_type_Int);
        long l;
        if (TextUtils.isEmpty(localVideoInfo.j))
        {
          l = 0L;
          ((Bundle)localObject5).putLong("publishAccountUin", l);
          ((Bundle)localObject5).putString("publishAccountName", (String)localObject3);
          ((Bundle)localObject5).putLong("feedsId", localVideoInfo.jdField_d_of_type_Long);
          ((Bundle)localObject5).putInt("feedsType", localVideoInfo.jdField_g_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_Int != 6) {
            break label1764;
          }
          i = 1;
          ((Bundle)localObject5).putInt("videoType", i);
          if (localVideoInfo.jdField_g_of_type_JavaLangString != null) {
            break label1769;
          }
        }
        for (localObject3 = "";; localObject3 = localVideoInfo.jdField_g_of_type_JavaLangString)
        {
          pej.a().a(rhf.a(this.a), rhf.a(this.a).c(), 2, (String)localObject3, localVideoInfo.c, localVideoInfo.jdField_d_of_type_JavaLangString, localVideoInfo.jdField_b_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_JavaLangString + "&sourcefrom=6", (Bundle)localObject5);
          localVideoInfo.jdField_d_of_type_Boolean = true;
          m = 4;
          k = -1;
          i = j;
          j = m;
          break;
          l = Long.valueOf(localVideoInfo.j).longValue();
          break label1582;
          label1764:
          i = 2;
          break label1639;
        }
        rhf.a(this.a).a(rhf.b(this.a));
        label1831:
        Object localObject7;
        Bitmap localBitmap;
        if (paramInteger.intValue() == 4)
        {
          j = 3;
          localObject3 = (String)localObject6 + "&sourcefrom=2";
          i = 2;
          localObject7 = new StringBuilder();
          if (localVideoInfo.p > 0) {
            ((StringBuilder)localObject7).append(rdm.b(localVideoInfo.p)).append(" ");
          }
          localObject5 = (BaseActivity)rhf.a(this.a);
          localObject6 = localVideoInfo.c;
          localObject7 = ((StringBuilder)localObject7).toString();
          localBitmap = rhf.a(this.a);
          if (paramInteger.intValue() != 4) {
            break label2008;
          }
        }
        label2008:
        for (boolean bool = true;; bool = false)
        {
          nte.a((BaseActivity)localObject5, (String)localObject6, (String)localObject7, (String)localObject3, localBitmap, bool, localVideoInfo.jdField_g_of_type_JavaLangString, new ria(rhf.a(this.a), rhf.a(this.a), rhf.b(this.a), j, -1, localVideoInfo));
          m = -1;
          k = j;
          j = m;
          break;
          j = 4;
          localObject3 = (String)localObject6 + "&sourcefrom=3";
          i = 4;
          break label1831;
        }
        if (localVideoInfo.jdField_a_of_type_Int == 0) {
          return false;
        }
        rhf.a(this.a).a(rhf.b(this.a));
        localObject3 = ors.a(localVideoInfo.jdField_g_of_type_JavaLangString, 3, localVideoInfo.h, -1, localVideoInfo.jdField_f_of_type_Long, localVideoInfo.o);
        localObject5 = new Intent(rhf.a(this.a), QQBrowserActivity.class);
        ((Intent)localObject5).putExtra("url", (String)localObject3);
        ((Intent)localObject5).putExtra("hide_more_button", true);
        rhf.a(this.a).startActivity((Intent)localObject5);
        i = 3;
        j = -1;
        k = -1;
        break;
        i = 5;
        rhf.a(this.a, localVideoInfo.c, "", (String)localObject6 + "&sourcefrom=4", localVideoInfo.jdField_b_of_type_JavaLangString);
        j = -1;
        k = 5;
        break;
        rhf.b(this.a, true);
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("channel_id", 409409);
          ((JSONObject)localObject3).put("source", 2);
          localObject5 = rhf.a(this.a);
          if ((((VideoInfo)localObject5).jdField_b_of_type_JavaUtilArrayList != null) && (((VideoInfo)localObject5).jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            rhf.a(this.a, (bhuf)bhus.a(rhf.a(this.a), null));
            localObject6 = new rhu(this);
            rhf.a(this.a).a((bhun)localObject6);
            localObject6 = new ReadInJoyDisLikeDialogView(rhf.a(this.a));
            ((ReadInJoyDisLikeDialogView)localObject6).setOnUninterestConfirmListener(new rhv(this, (VideoInfo)localObject5, (JSONObject)localObject3));
            ((ReadInJoyDisLikeDialogView)localObject6).setUninterestData(((VideoInfo)localObject5).jdField_b_of_type_JavaUtilArrayList);
            rhf.a(this.a).a((View)localObject6, null);
            try
            {
              if (!rhf.a(this.a).isShowing())
              {
                if ((bhtb.g()) && (!ShortVideoUtils.c()))
                {
                  rhf.a(this.a).getWindow().setFlags(8, 8);
                  rhf.a(this.a).getWindow().getDecorView().setSystemUiVisibility(rhf.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
                  rhf.a(this.a).setOnShowListener(new rhw(this));
                }
                rhf.a(this.a).show();
                nrt.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new ron(ntd.a(null, null, null, null, (JSONObject)localObject3)).h(((VideoInfo)localObject5).jdField_g_of_type_JavaLangString).a().a(), false);
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                rhf.a(this.a, "dislikeSheet.show exception=" + localException2);
              }
            }
            i = 3;
            j = 7;
            k = -1;
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
          rhf.a(this.a, "文章ID为：" + localJSONException.jdField_g_of_type_JavaLangString + alud.a(2131716636));
          i = 3;
          j = 7;
          k = -1;
        }
      }
      break label275;
      rhf.c(this.a, true);
      rhf.a(this.a).a(true);
      Object localObject4 = new Intent(rhf.a(this.a), AccountDetailActivity.class);
      ((Intent)localObject4).putExtra("uin", String.valueOf(2062433139L));
      ((Intent)localObject4).putExtra("uintype", 1008);
      ((Intent)localObject4).putExtra("source", 120);
      rhf.a(this.a).startActivity((Intent)localObject4);
      nrt.a(null, "", "0X800932E", "0X800932E", 0, 0, "", "", "", ntd.a(null));
      i = 3;
      j = -1;
      k = -1;
      break label275;
      this.a.a.d((String)localObject6);
      i = 3;
      j = 2;
      k = -1;
      break label275;
      rhf.a(this.a).a(rhf.b(this.a));
      if (localVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (TextUtils.isEmpty(localVideoInfo.j)) {
          break;
        }
        localObject4 = oqu.jdField_g_of_type_JavaLangString + bdfr.encodeToString(localVideoInfo.j.getBytes(), 2);
        ors.a(rhf.a(this.a), (String)localObject4);
        i = 3;
        j = -1;
        k = -1;
        break label275;
      }
      if ((TextUtils.isEmpty(localVideoInfo.j)) || (localVideoInfo.j.equals("16888"))) {
        break;
      }
      localObject4 = oqu.k + bdfr.encodeToString(localVideoInfo.j.getBytes(), 2);
      ors.a(rhf.a(this.a), (String)localObject4);
      i = 3;
      j = -1;
      k = -1;
      break label275;
      localObject4 = rhf.a(this.a);
      if (localObject4 == null) {
        break;
      }
      roi.a(rhf.a(this.a), qys.a((VideoInfo)localObject4), rhf.a(this.a).a(((VideoInfo)localObject4).jdField_g_of_type_JavaLangString), 1, 0);
      roi.a(((VideoInfo)localObject4).jdField_g_of_type_JavaLangString, 1, 1);
      break;
      localObject4 = null;
      break label445;
      label2990:
      localObject6 = rhf.a(this.a);
      if (rhf.b(this.a) != null) {}
      for (localObject4 = rhf.b(this.a).jdField_g_of_type_JavaLangString;; localObject4 = null)
      {
        ntd.b((VideoInfo)localObject6, m, 26, -1, localJSONException, (String)localObject4);
        break;
      }
      label3044:
      localObject4 = null;
      break label485;
      m = 0;
      break label513;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rht
 * JD-Core Version:    0.7.0.1
 */