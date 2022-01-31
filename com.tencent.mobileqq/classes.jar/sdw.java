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

class sdw
  extends sgy
{
  sdw(sds paramsds) {}
  
  protected boolean a(Integer paramInteger)
  {
    if ((TextUtils.isEmpty(sds.a(this.a))) || (TextUtils.isEmpty(sds.b(this.a))) || (TextUtils.isEmpty(sds.c(this.a))) || (TextUtils.isEmpty(sds.d(this.a)))) {
      return false;
    }
    int j;
    int i;
    if (paramInteger.intValue() == 2)
    {
      sds.a(this.a, sds.b(this.a), sds.c(this.a), sds.a(this.a), sds.e(this.a), sds.d(this.a), sds.f(this.a), sds.g(this.a), sds.h(this.a));
      j = 1;
      i = 0;
    }
    label296:
    label353:
    long l1;
    long l2;
    for (;;)
    {
      old.a(26, Long.valueOf(sds.a(this.a).c()).longValue(), (int)sds.b(this.a), 1, sds.a(this.a), sds.c(this.a), sds.d(this.a), sds.i(this.a), sds.k(this.a));
      sds.a(this.a, j, i, false);
      sds.b(this.a, j, i, false);
      return super.a(paramInteger);
      if (paramInteger.intValue() == 3)
      {
        sds.a(this.a, sds.b(this.a), sds.c(this.a), sds.a(this.a), sds.d(this.a));
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
            str2 = sds.d(this.a);
            if (paramInteger.intValue() != 4) {
              break label353;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((sds)localObject).a(str2, bool, new sdx(this, i, 0));
            j = i;
            i = 0;
            break;
            i = 4;
            break label296;
          }
        }
        if (paramInteger.intValue() == 6)
        {
          sds.b(this.a, sds.b(this.a), sds.c(this.a), sds.a(this.a), sds.d(this.a));
          j = 5;
          i = 0;
        }
        else if (paramInteger.intValue() == 7)
        {
          sds.a(this.a).a(sds.a(this.a));
          j = 6;
          i = 0;
        }
        else if (paramInteger.intValue() == 8)
        {
          sds.a(this.a).b(sds.a(this.a));
          j = 7;
          i = 0;
        }
        else if (paramInteger.intValue() == 1)
        {
          sds.a(sds.a(this.a), sds.a(this.a));
          j = 8;
          i = 0;
        }
        else if (paramInteger.intValue() == 12)
        {
          if (bbfj.g(sds.a(this.a)))
          {
            localObject = new Bundle();
            if (sds.a(this.a).mPictures != null) {
              ((Bundle)localObject).putInt("picNum", sds.a(this.a).mPictures.length);
            }
            if (!TextUtils.isEmpty(sds.a(this.a).mSubscribeID)) {
              l1 = 0L;
            }
            try
            {
              l2 = Long.parseLong(sds.a(this.a).mSubscribeID);
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
            ((Bundle)localObject).putString("publishAccountName", sds.a(this.a).mSubscribeName);
            ozb.a().a(sds.a(this.a), sds.a(this.a).getAccount(), 3, sds.i(this.a), sds.b(this.a), "", sds.d(this.a), sds.a(this.a), (Bundle)localObject);
            sds.a(this.a).add(sds.i(this.a));
            i = 4;
            j = 0;
            continue;
          }
          bcql.a(sds.a(this.a), 1, sds.a(this.a).getString(2131718340), 0).a();
          i = 4;
          j = 0;
        }
        else
        {
          if (paramInteger.intValue() != 14) {
            break;
          }
          localObject = sds.a(this.a);
          sds.a(this.a);
          ((ClipboardManager)((Context)localObject).getSystemService("clipboard")).setText(sds.a(this.a) + "&source=" + 11);
          wij.a(2, 2131691309);
          i = 3;
          j = 0;
        }
      }
    }
    if (paramInteger.intValue() == 20)
    {
      localObject = URLEncoder.encode(sds.a(this.a));
      if (TextUtils.isEmpty(sds.a(this.a).mSubscribeID)) {
        break label1396;
      }
      l1 = 0L;
      try
      {
        l2 = Long.parseLong(sds.a(this.a).mSubscribeID);
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
    for (Object localObject = String.format("https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d", new Object[] { Long.valueOf(l1), sds.i(this.a), localObject, Integer.valueOf(6) });; str1 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d")
    {
      for (;;)
      {
        Intent localIntent = new Intent(sds.a(this.a), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        sds.a(this.a).startActivity(localIntent);
        i = 5;
        j = 0;
        break;
        if (paramInteger.intValue() == 13)
        {
          sds.a(this.a).d(sds.a(this.a) + "&source=" + 11);
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
            sds.a(this.a, (bfpc)bfpp.a(sds.a(this.a), null));
            localObject = new ReadInJoyDisLikeDialogView(sds.a(this.a));
            ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new sdy(this));
            ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(this.a.a);
            sds.a(this.a).a((View)localObject, null);
            if (!sds.a(this.a).isShowing())
            {
              if ((bfnz.g()) && (!ShortVideoUtils.c()))
              {
                sds.a(this.a).getWindow().getDecorView().setSystemUiVisibility(2);
                sds.a(this.a).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new sdz(this));
              }
              sds.a(this.a).show();
              localObject = old.a(BaseApplicationImpl.getContext(), sds.a(this.a).getLongAccountUin(), sds.a(this.a), null, sds.i(this.a), sds.b(this.a));
              nol.a(null, sds.j(this.a), "0X8009807", "0X8009807", 0, 0, "", "" + sds.a(this.a), "", (String)localObject, false);
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
 * Qualified Name:     sdw
 * JD-Core Version:    0.7.0.1
 */