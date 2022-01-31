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
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class qgm
  extends ruj
{
  qgm(qfy paramqfy) {}
  
  protected boolean a(Integer paramInteger)
  {
    if (qfy.a(this.a) == null) {
      return false;
    }
    VideoInfo localVideoInfo = qfy.a(this.a);
    if (qfy.a(this.a) != null) {
      qfy.a(this.a).a(localVideoInfo);
    }
    Object localObject1 = new StringBuilder();
    Object localObject5 = qfy.a(this.a).a();
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
    label267:
    int m;
    switch (paramInteger.intValue())
    {
    default: 
      i = 3;
      j = -1;
      k = -1;
      if ((paramInteger.intValue() != 14) && (paramInteger.intValue() != 20) && (paramInteger.intValue() != 12) && (!qfy.e(this.a)))
      {
        localObject5 = new pqh();
        ((pqh)localObject5).jdField_d_of_type_Int = ((int)qfy.a(this.a).a());
        ((pqh)localObject5).e = (localVideoInfo.a() * 1000);
        m = -1;
        if (qfy.a(this.a) != null)
        {
          ((pqh)localObject5).b = qfy.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
          m = qfy.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
        }
        if (qfy.c(this.a) != 1) {
          break label2908;
        }
        localObject6 = qfy.a(this.a);
        if (qfy.b(this.a) != null)
        {
          localObject1 = qfy.b(this.a).g;
          label437:
          new.a((VideoInfo)localObject6, m, 26, -1, (pqh)localObject5, (String)localObject1);
        }
      }
      else
      {
        if ((localVideoInfo.jdField_a_of_type_Int != 0) || (localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
          break label2962;
        }
        localObject1 = localVideoInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
        label477:
        if (qfy.a(this.a) == null) {
          break label2968;
        }
        m = qfy.a(this.a).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        label505:
        if (localVideoInfo.N == null) {
          break label2974;
        }
      }
      break;
    }
    label1566:
    label1623:
    label1753:
    label2908:
    String str;
    label1815:
    label2968:
    label2974:
    for (localObject5 = localVideoInfo.N;; str = "")
    {
      for (;;)
      {
        for (;;)
        {
          qfy.a(this.a, localVideoInfo.j, Integer.toString(i), localVideoInfo.g, (String)localObject1, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.a(), localVideoInfo.jdField_f_of_type_Long, localVideoInfo.r, -1, m, (String)localObject5, false);
          qfy.a(this.a, localVideoInfo, localVideoInfo.j, localVideoInfo.g, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_Long, k, j, false);
          return super.a(paramInteger);
          try
          {
            if (qfy.a(this.a) != null)
            {
              qfy.a(this.a).a(qfy.b(this.a));
              localObject1 = new Intent(qfy.a(this.a), ReadInJoyDeliverBiuActivity.class);
              if ((qfy.a(this.a).jdField_a_of_type_Int == 6) && (qfy.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)) {
                ((Intent)localObject1).putExtra("feedsType", qfy.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType);
              }
              ((Intent)localObject1).putExtra("ARG_VIDEO_ARTICLE_ID", qfy.a(this.a).g);
              ((Intent)localObject1).putExtra("biu_src", 2);
              ((Intent)localObject1).putExtra("arg_from_type", 8);
              ((Intent)localObject1).putExtra("arg_article_info", qfy.a(this.a).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
              qfy.a(this.a).startActivityForResult((Intent)localObject1, 102);
              qfy.a(this.a).overridePendingTransition(0, 0);
            }
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("VideoFeedsShareController", 2, "innerOpenReadInJoyBiuActivity error exception = " + localException1.getMessage());
              }
              qfy.a(this.a).a(false);
            }
          }
          i = 3;
          j = -1;
          k = 0;
          break;
          ((ClipboardManager)qfy.a(this.a).getSystemService("clipboard")).setText((CharSequence)localObject6);
          vvp.a(2, 2131625733);
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
              localObject2 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=" + (String)localObject5 + "&uin_type=" + i + "&url=" + (String)localObject2 + "&type=4&key=" + localVideoInfo.g;
              qfy.a(this.a, "click jubao btn, reportUrl:" + (String)localObject2);
              qfy.a(this.a).a(qfy.b(this.a));
              localObject5 = new Intent(qfy.a(this.a), QQBrowserActivity.class);
              ((Intent)localObject5).putExtra("url", (String)localObject2);
              ((Intent)localObject5).putExtra("hide_more_button", true);
              qfy.a(this.a).startActivity((Intent)localObject5);
              i = 3;
              j = 5;
              k = -1;
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              qfy.a(this.a, "encode url failed, because UTF-8 is unknown");
              localObject3 = localObject5;
              continue;
              localObject5 = "0";
            }
          }
        }
        qfy.a(this.a, localVideoInfo);
        i = 0;
        j = -1;
        k = 1;
        break;
        qfy.a(this.a).a(qfy.b(this.a));
        this.a.a.a((String)localObject6 + "&sourcefrom=6");
        i = 3;
        j = -1;
        k = 6;
        break;
        qfy.a(this.a).a(qfy.b(this.a));
        this.a.a.b((String)localObject6 + "&sourcefrom=6");
        i = 3;
        j = -1;
        k = 7;
        break;
        i = 1;
        qfy.a(this.a).a(qfy.b(this.a));
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("title", localVideoInfo.c);
        ((Bundle)localObject3).putString("desc", localVideoInfo.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject3).putString("detail_url", (String)localObject6 + "&sourcefrom=1");
        localObject5 = new ArrayList(1);
        ((ArrayList)localObject5).add(localVideoInfo.jdField_b_of_type_JavaLangString);
        ((Bundle)localObject3).putStringArrayList("image_url", (ArrayList)localObject5);
        ((Bundle)localObject3).putLong("req_share_id", 0L);
        bfqn.a(qfy.a(this.a), qfy.a(this.a), (Bundle)localObject3, null);
        j = -1;
        k = 2;
        break;
        if (!badq.g(qfy.a(this.a)))
        {
          bbmy.a(qfy.a(this.a), 0, ajjy.a(2131650406), 0).a();
          return false;
        }
        qcn.a(qfy.a(this.a), qfy.a(this.a));
        j = 6;
        localVideoInfo.e = true;
        qfy.a(this.a).a(qfy.b(this.a));
        if ((qfy.a(this.a) instanceof VideoFeedsPlayActivity)) {
          ((VideoFeedsPlayActivity)qfy.a(this.a)).d(true);
        }
        localObject3 = localVideoInfo.jdField_k_of_type_JavaLangString;
        localObject5 = new Bundle();
        ((Bundle)localObject5).putInt("videoDuration", localVideoInfo.jdField_d_of_type_Int);
        long l;
        if (TextUtils.isEmpty(localVideoInfo.j))
        {
          l = 0L;
          ((Bundle)localObject5).putLong("publishAccountUin", l);
          ((Bundle)localObject5).putString("publishAccountName", (String)localObject3);
          ((Bundle)localObject5).putLong("feedsId", localVideoInfo.jdField_d_of_type_Long);
          ((Bundle)localObject5).putInt("feedsType", localVideoInfo.jdField_k_of_type_Int);
          if (localVideoInfo.jdField_a_of_type_Int != 6) {
            break label1748;
          }
          i = 1;
          ((Bundle)localObject5).putInt("videoType", i);
          if (localVideoInfo.g != null) {
            break label1753;
          }
        }
        for (localObject3 = "";; localObject3 = localVideoInfo.g)
        {
          onp.a().a(qfy.a(this.a), qfy.a(this.a).c(), 2, (String)localObject3, localVideoInfo.c, localVideoInfo.jdField_d_of_type_JavaLangString, localVideoInfo.jdField_b_of_type_JavaLangString, localVideoInfo.jdField_f_of_type_JavaLangString + "&sourcefrom=6", (Bundle)localObject5);
          localVideoInfo.jdField_d_of_type_Boolean = true;
          m = 4;
          k = -1;
          i = j;
          j = m;
          break;
          l = Long.valueOf(localVideoInfo.j).longValue();
          break label1566;
          label1748:
          i = 2;
          break label1623;
        }
        qfy.a(this.a).a(qfy.b(this.a));
        Object localObject7;
        Bitmap localBitmap;
        if (paramInteger.intValue() == 4)
        {
          j = 3;
          localObject3 = (String)localObject6 + "&sourcefrom=2";
          i = 2;
          localObject7 = new StringBuilder();
          if (localVideoInfo.s > 0) {
            ((StringBuilder)localObject7).append(qcn.b(localVideoInfo.s)).append(" ");
          }
          localObject5 = (BaseActivity)qfy.a(this.a);
          localObject6 = localVideoInfo.c;
          localObject7 = ((StringBuilder)localObject7).toString();
          localBitmap = qfy.a(this.a);
          if (paramInteger.intValue() != 4) {
            break label1992;
          }
        }
        label1992:
        for (boolean bool = true;; bool = false)
        {
          nex.a((BaseActivity)localObject5, (String)localObject6, (String)localObject7, (String)localObject3, localBitmap, bool, localVideoInfo.g, new qgt(qfy.a(this.a), qfy.a(this.a), qfy.b(this.a), j, -1, localVideoInfo));
          m = -1;
          k = j;
          j = m;
          break;
          j = 4;
          localObject3 = (String)localObject6 + "&sourcefrom=3";
          i = 4;
          break label1815;
        }
        if (localVideoInfo.jdField_a_of_type_Int == 0) {
          return false;
        }
        qfy.a(this.a).a(qfy.b(this.a));
        localObject3 = obz.a(localVideoInfo.g, 3, localVideoInfo.h, -1, localVideoInfo.jdField_f_of_type_Long, localVideoInfo.r);
        localObject5 = new Intent(qfy.a(this.a), QQBrowserActivity.class);
        ((Intent)localObject5).putExtra("url", (String)localObject3);
        ((Intent)localObject5).putExtra("hide_more_button", true);
        qfy.a(this.a).startActivity((Intent)localObject5);
        i = 3;
        j = -1;
        k = -1;
        break;
        i = 5;
        qfy.a(this.a, localVideoInfo.c, "", (String)localObject6 + "&sourcefrom=4", localVideoInfo.jdField_b_of_type_JavaLangString);
        j = -1;
        k = 5;
        break;
        qfy.b(this.a, true);
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("channel_id", 409409);
          ((JSONObject)localObject3).put("source", 2);
          localObject5 = qfy.a(this.a);
          if ((((VideoInfo)localObject5).jdField_b_of_type_JavaUtilArrayList != null) && (((VideoInfo)localObject5).jdField_b_of_type_JavaUtilArrayList.size() > 0))
          {
            qfy.a(this.a, (begr)behe.a(qfy.a(this.a), null));
            localObject6 = new qgn(this);
            qfy.a(this.a).a((begz)localObject6);
            localObject6 = new ReadInJoyDisLikeDialogView(qfy.a(this.a));
            ((ReadInJoyDisLikeDialogView)localObject6).setOnUninterestConfirmListener(new qgo(this, (VideoInfo)localObject5, (JSONObject)localObject3));
            ((ReadInJoyDisLikeDialogView)localObject6).setUninterestData(((VideoInfo)localObject5).jdField_b_of_type_JavaUtilArrayList);
            qfy.a(this.a).a((View)localObject6, null);
            try
            {
              if (!qfy.a(this.a).isShowing())
              {
                if ((befo.g()) && (!ShortVideoUtils.c()))
                {
                  qfy.a(this.a).getWindow().setFlags(8, 8);
                  qfy.a(this.a).getWindow().getDecorView().setSystemUiVisibility(qfy.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
                  qfy.a(this.a).setOnShowListener(new qgp(this));
                }
                qfy.a(this.a).show();
                ndn.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new qmv(new.a(null, null, null, null, (JSONObject)localObject3)).h(((VideoInfo)localObject5).g).a().a(), false);
              }
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                qfy.a(this.a, "dislikeSheet.show exception=" + localException2);
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
          qfy.a(this.a, "文章ID为：" + localJSONException.g + ajjy.a(2131650450));
          i = 3;
          j = 7;
          k = -1;
        }
      }
      break label267;
      qfy.c(this.a, true);
      qfy.a(this.a).a(true);
      Object localObject4 = new Intent(qfy.a(this.a), AccountDetailActivity.class);
      ((Intent)localObject4).putExtra("uin", String.valueOf(2062433139L));
      ((Intent)localObject4).putExtra("uintype", 1008);
      ((Intent)localObject4).putExtra("source", 120);
      qfy.a(this.a).startActivity((Intent)localObject4);
      ndn.a(null, "", "0X800932E", "0X800932E", 0, 0, "", "", "", new.a(null));
      i = 3;
      j = -1;
      k = -1;
      break label267;
      this.a.a.d((String)localObject6);
      i = 3;
      j = 2;
      k = -1;
      break label267;
      qfy.a(this.a).a(qfy.b(this.a));
      if (localVideoInfo.jdField_a_of_type_Int == 6)
      {
        if (TextUtils.isEmpty(localVideoInfo.j)) {
          break;
        }
        localObject4 = obb.g + baaw.encodeToString(localVideoInfo.j.getBytes(), 2);
        obz.a(qfy.a(this.a), (String)localObject4);
        i = 3;
        j = -1;
        k = -1;
        break label267;
      }
      if ((TextUtils.isEmpty(localVideoInfo.j)) || (localVideoInfo.j.equals("16888"))) {
        break;
      }
      localObject4 = obb.jdField_k_of_type_JavaLangString + baaw.encodeToString(localVideoInfo.j.getBytes(), 2);
      obz.a(qfy.a(this.a), (String)localObject4);
      break;
      localObject4 = null;
      break label437;
      localObject6 = qfy.a(this.a);
      if (qfy.b(this.a) != null) {}
      for (localObject4 = qfy.b(this.a).g;; localObject4 = null)
      {
        new.b((VideoInfo)localObject6, m, 26, -1, localJSONException, (String)localObject4);
        break;
      }
      localObject4 = null;
      break label477;
      m = 0;
      break label505;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qgm
 * JD-Core Version:    0.7.0.1
 */