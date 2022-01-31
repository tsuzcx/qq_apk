import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class orz
  implements ory
{
  private Context jdField_a_of_type_AndroidContentContext;
  private opw jdField_a_of_type_Opw;
  private qoe jdField_a_of_type_Qoe;
  private qpi jdField_a_of_type_Qpi;
  private qtb jdField_a_of_type_Qtb;
  
  public orz(Context paramContext, qpi paramqpi, qoe paramqoe)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Qpi = paramqpi;
    this.jdField_a_of_type_Qoe = paramqoe;
  }
  
  public static List<articlesummary.PackJumpInfo> a(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.SpecialTopicInfo)paramArticleInfo.mPackInfoObj.msg_special_topic_info.get()).rpt_jumps.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter special topic link list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo)
  {
    int i = 0;
    while (i < 4)
    {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_Qtb.h.setOnClickListener(null);
    switch (paramInt)
    {
    }
    List localList;
    int j;
    for (;;)
    {
      localList = null;
      for (;;)
      {
        if ((localList != null) && (localList.size() == 1)) {
          a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
        }
        if ((localList == null) || (localList.size() <= 1)) {
          break label213;
        }
        j = 1;
        i = 0;
        while (i < localList.size())
        {
          if (((articlesummary.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
            j = 0;
          }
          i += 1;
        }
        localList = a(paramArticleInfo);
        continue;
        localList = b(paramArticleInfo);
      }
      a(paramInt, paramArticleInfo, null);
    }
    if (j != 0)
    {
      a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
      label213:
      return;
    }
    a(paramInt, paramArticleInfo, localList);
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, List<articlesummary.PackJumpInfo> paramList)
  {
    this.jdField_a_of_type_Qtb.h.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    paramArticleInfo = paramList.iterator();
    Object localObject1;
    int i;
    for (paramInt = 0; paramArticleInfo.hasNext(); paramInt = i)
    {
      localObject1 = (articlesummary.PackJumpInfo)paramArticleInfo.next();
      i = paramInt;
      if (((articlesummary.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new osf(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new osg(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidViewView[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new osd(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramArticleInfo);
        this.jdField_a_of_type_Qtb.h.setOnClickListener(paramArticleInfo);
        return;
      }
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramArticleInfo);
      this.jdField_a_of_type_Qtb.h.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new ose(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_Qtb.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_Qtb.h.setOnClickListener(paramPackJumpInfo);
  }
  
  public static void a(int paramInt, String paramString) {}
  
  public static List<articlesummary.PackJumpInfo> b(ArticleInfo paramArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_jumps.get());
      if (localArrayList.isEmpty()) {
        QLog.w("ReadInJoyFooterPresenter", 1, "ReadInJoyFooter friend recommend link list empty");
      }
      return localArrayList;
    }
    catch (Exception paramArticleInfo)
    {
      for (;;)
      {
        paramArticleInfo.printStackTrace();
      }
    }
  }
  
  public void a(qtb paramqtb, opw paramopw, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Qtb = paramqtb;
    this.jdField_a_of_type_Opw = paramopw;
    paramopw = this.jdField_a_of_type_Opw.a();
    if (paramopw == null) {
      return;
    }
    label60:
    label206:
    label238:
    long l;
    label130:
    String str2;
    if (this.jdField_a_of_type_Qtb.h != null)
    {
      paramqtb = this.jdField_a_of_type_Qtb.h;
      if (this.jdField_a_of_type_Opw.b())
      {
        paramInt = 0;
        paramqtb.setVisibility(paramInt);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Opw.b())
      {
        this.jdField_a_of_type_Qtb.b();
        a(this.jdField_a_of_type_Opw.d(), paramopw);
      }
      if (this.jdField_a_of_type_Qtb.i != null)
      {
        paramqtb = this.jdField_a_of_type_Qtb.i;
        if (!this.jdField_a_of_type_Opw.c()) {
          break label715;
        }
        paramInt = 0;
        paramqtb.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_Opw.c())
      {
        this.jdField_a_of_type_Qtb.c();
        this.jdField_a_of_type_Qtb.c.setText(paramopw.mArticleFriendLikeText);
      }
      switch (paramopw.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_Qtb.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (this.jdField_a_of_type_Qtb.j != null)
        {
          paramqtb = this.jdField_a_of_type_Qtb.j;
          if (this.jdField_a_of_type_Opw.d())
          {
            paramInt = 0;
            paramqtb.setVisibility(paramInt);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Opw.d())
          {
            this.jdField_a_of_type_Qtb.d();
            this.jdField_a_of_type_Qtb.j.setOnClickListener(null);
            paramqtb = (articlesummary.CommentInfo)paramopw.mCommentsObj.get(0);
            l = paramqtb.uint64_uin.get();
            str2 = paramqtb.str_content.get();
            String str1 = paramqtb.str_jump_url.get();
            if (!obz.a()) {
              break label758;
            }
            paramqtb = babh.j((QQAppInterface)obz.a(), String.valueOf(l));
            label335:
            String str3 = obz.d(paramqtb);
            if (str3 == null) {
              break label771;
            }
            paramqtb = new SpannableString(str3 + ":  " + str2);
            paramqtb.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101491)), 0, str3.length(), 33);
            this.jdField_a_of_type_Qtb.d.setVisibility(0);
            this.jdField_a_of_type_Qtb.d.setText(str3 + ":  ");
            label454:
            this.jdField_a_of_type_Qtb.e.setText(paramqtb);
            this.jdField_a_of_type_Qtb.e.setOnClickListener(new osa(this, str1, paramopw));
            this.jdField_a_of_type_Qtb.d.setOnClickListener(new osb(this, l, paramopw));
            if (!this.jdField_a_of_type_Opw.f()) {
              break label796;
            }
            this.jdField_a_of_type_Qtb.k.setVisibility(0);
          }
          label530:
          if (this.jdField_a_of_type_Qtb.l != null)
          {
            paramqtb = this.jdField_a_of_type_Qtb.l;
            if (!this.jdField_a_of_type_Opw.e()) {
              break label811;
            }
            paramInt = 0;
            label562:
            paramqtb.setVisibility(paramInt);
          }
          if (this.jdField_a_of_type_Opw.e())
          {
            paramqtb = (LinearLayout.LayoutParams)this.jdField_a_of_type_Qtb.l.getLayoutParams();
            pmu.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Opw, paramqtb, this.jdField_a_of_type_Qtb.l);
            this.jdField_a_of_type_Qtb.l.setLayoutParams(paramqtb);
          }
          if (this.jdField_a_of_type_Qtb.m != null)
          {
            paramqtb = this.jdField_a_of_type_Qtb.m;
            if (!this.jdField_a_of_type_Opw.g()) {
              break label817;
            }
          }
        }
        break;
      }
    }
    label771:
    label796:
    label811:
    label817:
    for (paramInt = i;; paramInt = 8)
    {
      paramqtb.setVisibility(paramInt);
      if ((!this.jdField_a_of_type_Opw.g()) || (!this.jdField_a_of_type_Qtb.a())) {
        break;
      }
      this.jdField_a_of_type_Qtb.m.setOnClickListener(new osc(this));
      ohb.a().a(null);
      return;
      paramInt = 8;
      break label60;
      label715:
      paramInt = 8;
      break label130;
      paramqtb = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841246);
      this.jdField_a_of_type_Qtb.c.setCompoundDrawablesWithIntrinsicBounds(paramqtb, null, null, null);
      break label206;
      paramInt = 8;
      break label238;
      label758:
      paramqtb = this.jdField_a_of_type_Qoe.b(l);
      break label335;
      paramqtb = new SpannableString(str2);
      this.jdField_a_of_type_Qtb.d.setVisibility(8);
      break label454;
      this.jdField_a_of_type_Qtb.k.setVisibility(8);
      break label530;
      paramInt = 8;
      break label562;
    }
  }
  
  public void a(qtb paramqtb, opw paramopw, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orz
 * JD-Core Version:    0.7.0.1
 */