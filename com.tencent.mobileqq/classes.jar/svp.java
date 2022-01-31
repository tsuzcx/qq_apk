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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;

class svp
  extends syt
{
  svp(svl paramsvl) {}
  
  protected boolean a(Integer paramInteger)
  {
    if ((TextUtils.isEmpty(svl.a(this.a))) || (TextUtils.isEmpty(svl.b(this.a))) || (TextUtils.isEmpty(svl.c(this.a))) || (TextUtils.isEmpty(svl.d(this.a)))) {
      return false;
    }
    int j;
    int i;
    if (paramInteger.intValue() == 2)
    {
      svl.a(this.a, svl.b(this.a), svl.c(this.a), svl.a(this.a), svl.e(this.a), svl.d(this.a), svl.f(this.a), svl.g(this.a), svl.h(this.a));
      j = 1;
      i = 0;
    }
    label296:
    label353:
    long l1;
    long l2;
    for (;;)
    {
      opn.a(26, Long.valueOf(svl.a(this.a).c()).longValue(), (int)svl.b(this.a), 1, svl.a(this.a), svl.c(this.a), svl.d(this.a), svl.i(this.a), svl.k(this.a));
      svl.a(this.a, j, i, false);
      svl.b(this.a, j, i, false);
      return super.a(paramInteger);
      if (paramInteger.intValue() == 3)
      {
        svl.a(this.a, svl.b(this.a), svl.c(this.a), svl.a(this.a), svl.d(this.a));
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
            str2 = svl.d(this.a);
            if (paramInteger.intValue() != 4) {
              break label353;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ((svl)localObject).a(str2, bool, new svq(this, i, 0));
            j = i;
            i = 0;
            break;
            i = 4;
            break label296;
          }
        }
        if (paramInteger.intValue() == 6)
        {
          svl.b(this.a, svl.b(this.a), svl.c(this.a), svl.a(this.a), svl.d(this.a));
          j = 5;
          i = 0;
        }
        else if (paramInteger.intValue() == 7)
        {
          svl.a(this.a).a(svl.a(this.a));
          j = 6;
          i = 0;
        }
        else if (paramInteger.intValue() == 8)
        {
          svl.a(this.a).b(svl.a(this.a));
          j = 7;
          i = 0;
        }
        else if (paramInteger.intValue() == 1)
        {
          svl.a(svl.a(this.a), svl.a(this.a));
          j = 8;
          i = 0;
        }
        else if (paramInteger.intValue() == 12)
        {
          if (bdee.g(svl.a(this.a)))
          {
            localObject = new Bundle();
            if (svl.a(this.a).mPictures != null) {
              ((Bundle)localObject).putInt("picNum", svl.a(this.a).mPictures.length);
            }
            if (!TextUtils.isEmpty(svl.a(this.a).mSubscribeID)) {
              l1 = 0L;
            }
            try
            {
              l2 = Long.parseLong(svl.a(this.a).mSubscribeID);
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
            ((Bundle)localObject).putString("publishAccountName", svl.a(this.a).mSubscribeName);
            pej.a().a(svl.a(this.a), svl.a(this.a).getAccount(), 3, svl.i(this.a), svl.b(this.a), "", svl.d(this.a), svl.a(this.a), (Bundle)localObject);
            svl.a(this.a).add(svl.i(this.a));
            i = 4;
            j = 0;
            continue;
          }
          QQToast.a(svl.a(this.a), 1, svl.a(this.a).getString(2131718723), 0).a();
          i = 4;
          j = 0;
        }
        else
        {
          if (paramInteger.intValue() != 14) {
            break;
          }
          localObject = svl.a(this.a);
          svl.a(this.a);
          ((ClipboardManager)((Context)localObject).getSystemService("clipboard")).setText(svl.a(this.a) + "&source=" + 11);
          xxb.a(2, 2131691362);
          i = 3;
          j = 0;
        }
      }
    }
    if (paramInteger.intValue() == 20)
    {
      localObject = URLEncoder.encode(svl.a(this.a));
      if (TextUtils.isEmpty(svl.a(this.a).mSubscribeID)) {
        break label1396;
      }
      l1 = 0L;
      try
      {
        l2 = Long.parseLong(svl.a(this.a).mSubscribeID);
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
    for (Object localObject = String.format("https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d", new Object[] { Long.valueOf(l1), svl.i(this.a), localObject, Integer.valueOf(6) });; str1 = "https://post.mp.qq.com/jubao/index?_wv=3&puin=%1$d&key=%2$s&url=%3$s&type=%4$d")
    {
      for (;;)
      {
        Intent localIntent = new Intent(svl.a(this.a), QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        svl.a(this.a).startActivity(localIntent);
        i = 5;
        j = 0;
        break;
        if (paramInteger.intValue() == 13)
        {
          svl.a(this.a).d(svl.a(this.a) + "&source=" + 11);
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
            svl.a(this.a, (bhpy)bhql.a(svl.a(this.a), null));
            localObject = new ReadInJoyDisLikeDialogView(svl.a(this.a));
            ((ReadInJoyDisLikeDialogView)localObject).setOnUninterestConfirmListener(new svr(this));
            ((ReadInJoyDisLikeDialogView)localObject).setUninterestData(this.a.a);
            svl.a(this.a).a((View)localObject, null);
            if (!svl.a(this.a).isShowing())
            {
              if ((bhou.g()) && (!ShortVideoUtils.c()))
              {
                svl.a(this.a).getWindow().getDecorView().setSystemUiVisibility(2);
                svl.a(this.a).getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new svs(this));
              }
              svl.a(this.a).show();
              localObject = opn.a(BaseApplicationImpl.getContext(), svl.a(this.a).getLongAccountUin(), svl.a(this.a), null, svl.i(this.a), svl.b(this.a));
              nrt.a(null, svl.j(this.a), "0X8009807", "0X8009807", 0, 0, "", "" + svl.a(this.a), "", (String)localObject, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svp
 * JD-Core Version:    0.7.0.1
 */