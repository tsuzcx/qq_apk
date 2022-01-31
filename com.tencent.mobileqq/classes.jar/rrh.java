import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;

class rrh
  extends ruj
{
  rrh(rrd paramrrd) {}
  
  protected boolean a(Integer paramInteger)
  {
    if ((TextUtils.isEmpty(rrd.a(this.a))) || (TextUtils.isEmpty(rrd.b(this.a))) || (TextUtils.isEmpty(rrd.c(this.a))) || (TextUtils.isEmpty(rrd.d(this.a)))) {
      return false;
    }
    int j;
    int i;
    if (paramInteger.intValue() == 2)
    {
      rrd.a(this.a, rrd.b(this.a), rrd.c(this.a), rrd.a(this.a), rrd.e(this.a), rrd.d(this.a), rrd.f(this.a), rrd.g(this.a), rrd.h(this.a));
      j = 1;
      i = 0;
    }
    label296:
    label353:
    long l1;
    long l2;
    for (;;)
    {
      nzv.a(26, Long.valueOf(rrd.a(this.a).c()).longValue(), (int)rrd.b(this.a), 1, rrd.a(this.a), rrd.c(this.a), rrd.d(this.a), rrd.i(this.a), rrd.k(this.a));
      rrd.a(this.a, j, i, false);
      rrd.b(this.a, j, i, false);
      return super.a(paramInteger);
      if (paramInteger.intValue() == 3)
      {
        rrd.a(this.a, rrd.b(this.a), rrd.c(this.a), rrd.a(this.a), rrd.d(this.a));
        j = 2;
        i = 0;
      }
      else
      {
        if ((paramInteger.intValue() == 4) || (paramInteger.intValue() == 5))
        {
          String str2;
          if (paramInteger.intValue() == 4)
          {
            i = 3;
            localObject = this.a;
            str2 = rrd.d(this.a);
            if (paramInteger.intValue() != 4) {
              break label353;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((rrd)localObject).a(str2, bool, new rri(this, i, 0));
            j = i;
            i = 0;
            break;
            i = 4;
            break label296;
          }
        }
        if (paramInteger.intValue() == 6)
        {
          rrd.b(this.a, rrd.b(this.a), rrd.c(this.a), rrd.a(this.a), rrd.d(this.a));
          j = 5;
          i = 0;
        }
        else if (paramInteger.intValue() == 7)
        {
          rrd.a(this.a).a(rrd.a(this.a));
          j = 6;
          i = 0;
        }
        else if (paramInteger.intValue() == 8)
        {
          rrd.a(this.a).b(rrd.a(this.a));
          j = 7;
          i = 0;
        }
        else if (paramInteger.intValue() == 1)
        {
          rrd.a(rrd.a(this.a), rrd.a(this.a));
          j = 8;
          i = 0;
        }
        else if (paramInteger.intValue() == 12)
        {
          if (badq.g(rrd.a(this.a)))
          {
            localObject = new Bundle();
            if (rrd.a(this.a).mPictures != null) {
              ((Bundle)localObject).putInt("picNum", rrd.a(this.a).mPictures.length);
            }
            if (!TextUtils.isEmpty(rrd.a(this.a).mSubscribeID)) {
              l1 = 0L;
            }
            try
            {
              l2 = Long.parseLong(rrd.a(this.a).mSubscribeID);
              l1 = l2;
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              for (;;)
              {
                localNumberFormatException1.printStackTrace();
              }
            }
            ((Bundle)localObject).putLong("publishAccountUin", l1);
            ((Bundle)localObject).putString("publishAccountName", rrd.a(this.a).mSubscribeName);
            onp.a().a(rrd.a(this.a), rrd.a(this.a).getAccount(), 3, rrd.i(this.a), rrd.b(this.a), "", rrd.d(this.a), rrd.a(this.a), (Bundle)localObject);
            rrd.a(this.a).add(rrd.i(this.a));
            i = 4;
            j = 0;
            continue;
          }
          bbmy.a(rrd.a(this.a), 1, rrd.a(this.a).getString(2131652510), 0).a();
          i = 4;
          j = 0;
        }
        else
        {
          if (paramInteger.intValue() != 14) {
            break;
          }
          localObject = rrd.a(this.a);
          rrd.a(this.a);
          ((ClipboardManager)((Context)localObject).getSystemService("clipboard")).setText(rrd.a(this.a) + "&source=" + 11);
          vvp.a(2, 2131625733);
          i = 3;
          j = 0;
        }
      }
    }
    if (paramInteger.intValue() == 20)
    {
      localObject = URLEncoder.encode(rrd.a(this.a));
      if (TextUtils.isEmpty(rrd.a(this.a).mSubscribeID)) {
        break label1396;
      }
      l1 = 0L;
      try
      {
        l2 = Long.parseLong(rrd.a(this.a).mSubscribeID);
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          localNumberFormatException2.printStackTrace();
        }
      }
    }
    label1389:
    label1396:
    String str1;
    for (Object localObject = String.format("https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d", new Object[] { Long.valueOf(l1), rrd.i(this.a), localObject, Integer.valueOf(6) });; str1 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d")
    {
      for (;;)
      {
        Intent localIntent = new Intent(rrd.a(this.a), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        rrd.a(this.a).startActivity(localIntent);
        i = 5;
        j = 0;
        break;
        if (paramInteger.intValue() == 13)
        {
          rrd.a(this.a).d(rrd.a(this.a) + "&source=" + 11);
          i = 2;
          j = 0;
          break;
        }
        if (paramInteger.intValue() != 15) {
          break label1389;
        }
        if ((this.a.a != null) && (this.a.a.size() > 0)) {
          try
          {
            rrd.a(this.a, (begr)behe.a(rrd.a(this.a), null));
            localObject = new ReadInJoyDisLikeDialogView(rrd.a(this.a));
            ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new rrj(this));
            ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(this.a.a);
            rrd.a(this.a).a((View)localObject, null);
            if (!rrd.a(this.a).isShowing())
            {
              if ((befo.g()) && (!ShortVideoUtils.c()))
              {
                rrd.a(this.a).getWindow().getDecorView().setSystemUiVisibility(2);
                rrd.a(this.a).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new rrk(this));
              }
              rrd.a(this.a).show();
              localObject = nzv.a(BaseApplicationImpl.getContext(), rrd.a(this.a).getLongAccountUin(), rrd.a(this.a), null, rrd.i(this.a), rrd.b(this.a));
              ndn.a(null, rrd.j(this.a), "0X8009807", "0X8009807", 0, 0, "", "" + rrd.a(this.a), "", (String)localObject, false);
            }
            i = 7;
            j = 0;
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GalleryShareHelper", 2, "dislikeSheet.show exception=" + localException);
            }
          }
        }
      }
      i = 7;
      j = 0;
      break;
      i = 0;
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rrh
 * JD-Core Version:    0.7.0.1
 */