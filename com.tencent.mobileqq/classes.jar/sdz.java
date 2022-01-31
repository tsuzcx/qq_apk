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

class sdz
  extends shb
{
  sdz(sdv paramsdv) {}
  
  protected boolean a(Integer paramInteger)
  {
    if ((TextUtils.isEmpty(sdv.a(this.a))) || (TextUtils.isEmpty(sdv.b(this.a))) || (TextUtils.isEmpty(sdv.c(this.a))) || (TextUtils.isEmpty(sdv.d(this.a)))) {
      return false;
    }
    int j;
    int i;
    if (paramInteger.intValue() == 2)
    {
      sdv.a(this.a, sdv.b(this.a), sdv.c(this.a), sdv.a(this.a), sdv.e(this.a), sdv.d(this.a), sdv.f(this.a), sdv.g(this.a), sdv.h(this.a));
      j = 1;
      i = 0;
    }
    label296:
    label353:
    long l1;
    long l2;
    for (;;)
    {
      olg.a(26, Long.valueOf(sdv.a(this.a).c()).longValue(), (int)sdv.b(this.a), 1, sdv.a(this.a), sdv.c(this.a), sdv.d(this.a), sdv.i(this.a), sdv.k(this.a));
      sdv.a(this.a, j, i, false);
      sdv.b(this.a, j, i, false);
      return super.a(paramInteger);
      if (paramInteger.intValue() == 3)
      {
        sdv.a(this.a, sdv.b(this.a), sdv.c(this.a), sdv.a(this.a), sdv.d(this.a));
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
            str2 = sdv.d(this.a);
            if (paramInteger.intValue() != 4) {
              break label353;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((sdv)localObject).a(str2, bool, new sea(this, i, 0));
            j = i;
            i = 0;
            break;
            i = 4;
            break label296;
          }
        }
        if (paramInteger.intValue() == 6)
        {
          sdv.b(this.a, sdv.b(this.a), sdv.c(this.a), sdv.a(this.a), sdv.d(this.a));
          j = 5;
          i = 0;
        }
        else if (paramInteger.intValue() == 7)
        {
          sdv.a(this.a).a(sdv.a(this.a));
          j = 6;
          i = 0;
        }
        else if (paramInteger.intValue() == 8)
        {
          sdv.a(this.a).b(sdv.a(this.a));
          j = 7;
          i = 0;
        }
        else if (paramInteger.intValue() == 1)
        {
          sdv.a(sdv.a(this.a), sdv.a(this.a));
          j = 8;
          i = 0;
        }
        else if (paramInteger.intValue() == 12)
        {
          if (bbev.g(sdv.a(this.a)))
          {
            localObject = new Bundle();
            if (sdv.a(this.a).mPictures != null) {
              ((Bundle)localObject).putInt("picNum", sdv.a(this.a).mPictures.length);
            }
            if (!TextUtils.isEmpty(sdv.a(this.a).mSubscribeID)) {
              l1 = 0L;
            }
            try
            {
              l2 = Long.parseLong(sdv.a(this.a).mSubscribeID);
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
            ((Bundle)localObject).putString("publishAccountName", sdv.a(this.a).mSubscribeName);
            oze.a().a(sdv.a(this.a), sdv.a(this.a).getAccount(), 3, sdv.i(this.a), sdv.b(this.a), "", sdv.d(this.a), sdv.a(this.a), (Bundle)localObject);
            sdv.a(this.a).add(sdv.i(this.a));
            i = 4;
            j = 0;
            continue;
          }
          bcpw.a(sdv.a(this.a), 1, sdv.a(this.a).getString(2131718329), 0).a();
          i = 4;
          j = 0;
        }
        else
        {
          if (paramInteger.intValue() != 14) {
            break;
          }
          localObject = sdv.a(this.a);
          sdv.a(this.a);
          ((ClipboardManager)((Context)localObject).getSystemService("clipboard")).setText(sdv.a(this.a) + "&source=" + 11);
          wim.a(2, 2131691309);
          i = 3;
          j = 0;
        }
      }
    }
    if (paramInteger.intValue() == 20)
    {
      localObject = URLEncoder.encode(sdv.a(this.a));
      if (TextUtils.isEmpty(sdv.a(this.a).mSubscribeID)) {
        break label1396;
      }
      l1 = 0L;
      try
      {
        l2 = Long.parseLong(sdv.a(this.a).mSubscribeID);
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
    for (Object localObject = String.format("https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d", new Object[] { Long.valueOf(l1), sdv.i(this.a), localObject, Integer.valueOf(6) });; str1 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d")
    {
      for (;;)
      {
        Intent localIntent = new Intent(sdv.a(this.a), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        sdv.a(this.a).startActivity(localIntent);
        i = 5;
        j = 0;
        break;
        if (paramInteger.intValue() == 13)
        {
          sdv.a(this.a).d(sdv.a(this.a) + "&source=" + 11);
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
            sdv.a(this.a, (bfol)bfoy.a(sdv.a(this.a), null));
            localObject = new ReadInJoyDisLikeDialogView(sdv.a(this.a));
            ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new seb(this));
            ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(this.a.a);
            sdv.a(this.a).a((View)localObject, null);
            if (!sdv.a(this.a).isShowing())
            {
              if ((bfni.g()) && (!ShortVideoUtils.c()))
              {
                sdv.a(this.a).getWindow().getDecorView().setSystemUiVisibility(2);
                sdv.a(this.a).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new sec(this));
              }
              sdv.a(this.a).show();
              localObject = olg.a(BaseApplicationImpl.getContext(), sdv.a(this.a).getLongAccountUin(), sdv.a(this.a), null, sdv.i(this.a), sdv.b(this.a));
              noo.a(null, sdv.j(this.a), "0X8009807", "0X8009807", 0, 0, "", "" + sdv.a(this.a), "", (String)localObject, false);
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
 * Qualified Name:     sdz
 * JD-Core Version:    0.7.0.1
 */