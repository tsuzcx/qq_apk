import android.content.ClipboardManager;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.FastWebSheetItemClickProcessor.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ssk
  extends uha
{
  public ssk(FastWebActivity paramFastWebActivity) {}
  
  public boolean a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    FastWebActivity.c(this.a, true);
    FastWebActivity.a(this.a, paramInt);
    if (paramInt == 72)
    {
      FastWebActivity.a(this.a, paramActionSheetItem.uin);
      FastWebActivity.b(this.a, paramActionSheetItem.uinType);
      FastWebActivity.b(this.a, paramActionSheetItem.label);
    }
    FastWebActivity localFastWebActivity;
    String str;
    if (paramInt == 1)
    {
      ((ClipboardManager)this.a.getSystemService("clipboard")).setText(this.a.a.mArticleContentUrl);
      yyi.a(2, 2131691181);
      localFastWebActivity = this.a;
      if (FastWebActivity.b(this.a))
      {
        str = "0X8008994";
        swi.a(localFastWebActivity, str, 9, this.a.a);
        swy.a(this.a, this.a.getAppInterface(), this.a.a, -1, 3, false);
      }
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      str = "0X800898D";
      break;
      if (paramInt == 5)
      {
        FastWebActivity.a(this.a).a(this.a.a.mArticleContentUrl);
        swy.a(this.a, this.a.getAppInterface(), this.a.a, 6, -1, false);
      }
      else if (paramInt == 4)
      {
        FastWebActivity.a(this.a).b(this.a.a.mArticleContentUrl);
        swy.a(this.a, this.a.getAppInterface(), this.a.a, 7, -1, false);
      }
      else if (paramInt == 13)
      {
        this.a.a(17, -1, false);
        swy.a(this.a, this.a.getAppInterface(), this.a.a, 0, -1, false);
      }
      else
      {
        if (paramInt == 6)
        {
          if (FastWebActivity.a(this.a) != null) {
            FastWebActivity.a(this.a).setFavoriteArticle(this.a, this.a.a, FastWebActivity.a(this.a));
          }
          localFastWebActivity = this.a;
          if (FastWebActivity.b(this.a)) {}
          for (str = "0X8008994";; str = "0X800898D")
          {
            swi.a(localFastWebActivity, str, 8, this.a.a);
            swy.a(this.a, this.a.getAppInterface(), this.a.a, -1, 4, false);
            break;
          }
        }
        if (paramInt == 11)
        {
          ThreadManager.executeOnSubThread(new FastWebActivity.FastWebSheetItemClickProcessor.1(this));
          localFastWebActivity = this.a;
          if (FastWebActivity.b(this.a)) {}
          for (str = "0X8008994";; str = "0X800898D")
          {
            swi.a(localFastWebActivity, str, 10, this.a.a);
            swy.a(this.a, this.a.getAppInterface(), this.a.a, -1, 5, false);
            break;
          }
        }
        if (paramInt == 21)
        {
          FastWebActivity.a(this.a).c();
          localFastWebActivity = this.a;
          if (FastWebActivity.b(this.a)) {}
          for (str = "0X8008994";; str = "0X800898D")
          {
            swi.a(localFastWebActivity, str, 7, this.a.a);
            swy.a(this.a, this.a.getAppInterface(), this.a.a, -1, 0, false);
            break;
          }
        }
        if (paramInt == 7)
        {
          FastWebActivity.a(this.a).a(this.a, true);
          swy.a(this.a, this.a.getAppInterface(), this.a.a, -1, 1, false, false, ozw.a(null, "function_type", Integer.valueOf(7)));
        }
        else if (paramInt == 26)
        {
          FastWebActivity.a(this.a).d(this.a.a.mArticleContentUrl);
          swy.a(this.a, this.a.getAppInterface(), this.a.a, -1, 2, false);
        }
        else if (paramInt == 68)
        {
          bcua.a(1, 2);
          bcua.a(this.a.a.mArticleContentUrl, this.a.a.mTitle);
        }
        else if (paramInt == 70)
        {
          if (FastWebActivity.a(this.a) != null) {
            if (FastWebActivity.a(this.a).b())
            {
              QLog.d("FastWebActivity", 2, "mColorNoteController ：add colorNote");
              FastWebActivity.a(this.a).e();
              if (!FastWebActivity.a(this.a).a()) {
                QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690786), 5000).a();
              }
            }
            else
            {
              FastWebActivity.a(this.a).i();
            }
          }
        }
        else if (paramInt == 82)
        {
          if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).c()))
          {
            QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690790), 5000).a();
            FastWebActivity.a(this.a).f();
            QLog.d("FastWebActivity", 2, "mColorNoteController ： delete colorNote");
          }
        }
        else
        {
          pkm.a().a().a(this.a.a.mArticleContentUrl, this.a.a.innerUniqueID + "", this.a.a.mSubscribeID, paramInt, FastWebActivity.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ssk
 * JD-Core Version:    0.7.0.1
 */