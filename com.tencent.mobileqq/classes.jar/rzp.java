import android.content.ClipboardManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.FastWebSheetItemClickProcessor.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.utils.UriBuilder;

public class rzp
  extends syt
{
  public rzp(FastWebActivity paramFastWebActivity) {}
  
  protected boolean a(Integer paramInteger)
  {
    FastWebActivity.c(this.a, true);
    FastWebActivity localFastWebActivity;
    Object localObject;
    if (paramInteger.intValue() == 14)
    {
      ((ClipboardManager)this.a.getSystemService("clipboard")).setText(FastWebActivity.a(this.a).mArticleContentUrl);
      ybk.a(2, 2131691363);
      localFastWebActivity = this.a;
      if (FastWebActivity.d(this.a))
      {
        localObject = "0X8008994";
        scx.a(localFastWebActivity, (String)localObject, 9, FastWebActivity.a(this.a));
        sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, 3, false);
      }
    }
    for (;;)
    {
      return super.a(paramInteger);
      localObject = "0X800898D";
      break;
      if (paramInteger.intValue() == 7)
      {
        FastWebActivity.a(this.a).a(FastWebActivity.a(this.a).mArticleContentUrl);
        sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), 6, -1, false);
      }
      else if (paramInteger.intValue() == 8)
      {
        FastWebActivity.a(this.a).b(FastWebActivity.a(this.a).mArticleContentUrl);
        sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), 7, -1, false);
      }
      else if (paramInteger.intValue() == 1)
      {
        this.a.a(17, -1, false);
        sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), 0, -1, false);
      }
      else
      {
        if (paramInteger.intValue() == 12)
        {
          if (FastWebActivity.a(this.a) != null) {
            FastWebActivity.a(this.a).setFavoriteArticle(this.a, FastWebActivity.a(this.a), FastWebActivity.a(this.a));
          }
          localFastWebActivity = this.a;
          if (FastWebActivity.d(this.a)) {}
          for (localObject = "0X8008994";; localObject = "0X800898D")
          {
            scx.a(localFastWebActivity, (String)localObject, 8, FastWebActivity.a(this.a));
            sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, 4, false);
            break;
          }
        }
        if (paramInteger.intValue() == 20)
        {
          ThreadManager.executeOnSubThread(new FastWebActivity.FastWebSheetItemClickProcessor.1(this));
          localFastWebActivity = this.a;
          if (FastWebActivity.d(this.a)) {}
          for (localObject = "0X8008994";; localObject = "0X800898D")
          {
            scx.a(localFastWebActivity, (String)localObject, 10, FastWebActivity.a(this.a));
            sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, 5, false);
            break;
          }
        }
        if (paramInteger.intValue() == 9)
        {
          FastWebActivity.a(this.a).c();
          localFastWebActivity = this.a;
          if (FastWebActivity.d(this.a)) {}
          for (localObject = "0X8008994";; localObject = "0X800898D")
          {
            scx.a(localFastWebActivity, (String)localObject, 7, FastWebActivity.a(this.a));
            sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, 0, false);
            break;
          }
        }
        if (paramInteger.intValue() == 10)
        {
          FastWebActivity.a(this.a).a(this.a);
          sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, 1, false);
        }
        else if (paramInteger.intValue() == 13)
        {
          FastWebActivity.a(this.a).d(FastWebActivity.a(this.a).mArticleContentUrl);
          sdn.a(this.a, this.a.getAppInterface(), FastWebActivity.a(this.a), -1, 2, false);
        }
        else if (paramInteger.intValue() == 28)
        {
          bagk.a(1, 2);
          bagk.a(FastWebActivity.a(this.a).mArticleContentUrl, FastWebActivity.a(this.a).mTitle);
        }
        else if (paramInteger.intValue() == 32)
        {
          if (FastWebActivity.a(this.a) != null) {
            if (FastWebActivity.a(this.a).b())
            {
              QLog.d(FastWebActivity.a(this.a), 2, "mColorNoteController ：add colorNote");
              FastWebActivity.a(this.a).e();
              if (!FastWebActivity.a(this.a).a()) {
                QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690905), 5000).a();
              }
            }
            else
            {
              FastWebActivity.a(this.a).i();
            }
          }
        }
        else if (paramInteger.intValue() == 33)
        {
          if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).c()))
          {
            QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690909), 5000).a();
            FastWebActivity.a(this.a).f();
            QLog.d(FastWebActivity.a(this.a), 2, "mColorNoteController ： delete colorNote");
          }
        }
        else
        {
          if ((FastWebActivity.b(this.a)) && (!TextUtils.isEmpty(FastWebActivity.b(this.a))))
          {
            localObject = new UriBuilder();
            ((UriBuilder)localObject).setUrl(FastWebActivity.a(this.a).mArticleContentUrl);
            ((UriBuilder)localObject).addParam("redpackid", FastWebActivity.b(this.a));
            FastWebActivity.a(this.a).mArticleContentUrl = ((UriBuilder)localObject).buildUri();
          }
          owy.a().a().a(FastWebActivity.a(this.a).mArticleContentUrl, FastWebActivity.a(this.a).innerUniqueID + "", FastWebActivity.a(this.a).mSubscribeID, paramInteger.intValue(), FastWebActivity.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rzp
 * JD-Core Version:    0.7.0.1
 */