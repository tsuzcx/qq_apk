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

public class qam
  implements qal
{
  private Context jdField_a_of_type_AndroidContentContext;
  private pxk jdField_a_of_type_Pxk;
  private snh jdField_a_of_type_Snh;
  private spa jdField_a_of_type_Spa;
  private stc jdField_a_of_type_Stc;
  
  public qam(Context paramContext, spa paramspa, snh paramsnh)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Spa = paramspa;
    this.jdField_a_of_type_Snh = paramsnh;
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
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_Stc.h.setOnClickListener(null);
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
    this.jdField_a_of_type_Stc.h.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
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
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new qas(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new qat(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidViewView[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new qaq(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramArticleInfo);
        this.jdField_a_of_type_Stc.h.setOnClickListener(paramArticleInfo);
        return;
      }
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramArticleInfo);
      this.jdField_a_of_type_Stc.h.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new qar(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_Stc.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_Stc.h.setOnClickListener(paramPackJumpInfo);
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
  
  public void a(stc paramstc, pxk parampxk, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Stc = paramstc;
    this.jdField_a_of_type_Pxk = parampxk;
    parampxk = this.jdField_a_of_type_Pxk.a();
    if (parampxk == null) {
      return;
    }
    label60:
    label206:
    label238:
    long l;
    label130:
    String str2;
    if (this.jdField_a_of_type_Stc.h != null)
    {
      paramstc = this.jdField_a_of_type_Stc.h;
      if (this.jdField_a_of_type_Pxk.b())
      {
        paramInt = 0;
        paramstc.setVisibility(paramInt);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Pxk.b())
      {
        this.jdField_a_of_type_Stc.b();
        a(this.jdField_a_of_type_Pxk.d(), parampxk);
      }
      if (this.jdField_a_of_type_Stc.i != null)
      {
        paramstc = this.jdField_a_of_type_Stc.i;
        if (!this.jdField_a_of_type_Pxk.c()) {
          break label715;
        }
        paramInt = 0;
        paramstc.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_Pxk.c())
      {
        this.jdField_a_of_type_Stc.c();
        this.jdField_a_of_type_Stc.c.setText(parampxk.mArticleFriendLikeText);
      }
      switch (parampxk.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_Stc.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (this.jdField_a_of_type_Stc.j != null)
        {
          paramstc = this.jdField_a_of_type_Stc.j;
          if (this.jdField_a_of_type_Pxk.d())
          {
            paramInt = 0;
            paramstc.setVisibility(paramInt);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Pxk.d())
          {
            this.jdField_a_of_type_Stc.d();
            this.jdField_a_of_type_Stc.j.setOnClickListener(null);
            paramstc = (articlesummary.CommentInfo)parampxk.mCommentsObj.get(0);
            l = paramstc.uint64_uin.get();
            str2 = paramstc.str_content.get();
            String str1 = paramstc.str_jump_url.get();
            if (!pha.a()) {
              break label758;
            }
            paramstc = bglf.j((QQAppInterface)pha.a(), String.valueOf(l));
            label335:
            String str3 = pha.e(paramstc);
            if (str3 == null) {
              break label771;
            }
            paramstc = new SpannableString(str3 + ":  " + str2);
            paramstc.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167224)), 0, str3.length(), 33);
            this.jdField_a_of_type_Stc.d.setVisibility(0);
            this.jdField_a_of_type_Stc.d.setText(str3 + ":  ");
            label454:
            this.jdField_a_of_type_Stc.e.setText(paramstc);
            this.jdField_a_of_type_Stc.e.setOnClickListener(new qan(this, str1, parampxk));
            this.jdField_a_of_type_Stc.d.setOnClickListener(new qao(this, l, parampxk));
            if (!this.jdField_a_of_type_Pxk.f()) {
              break label796;
            }
            this.jdField_a_of_type_Stc.k.setVisibility(0);
          }
          label530:
          if (this.jdField_a_of_type_Stc.l != null)
          {
            paramstc = this.jdField_a_of_type_Stc.l;
            if (!this.jdField_a_of_type_Pxk.e()) {
              break label811;
            }
            paramInt = 0;
            label562:
            paramstc.setVisibility(paramInt);
          }
          if (this.jdField_a_of_type_Pxk.e())
          {
            paramstc = (LinearLayout.LayoutParams)this.jdField_a_of_type_Stc.l.getLayoutParams();
            qyo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pxk, paramstc, this.jdField_a_of_type_Stc.l);
            this.jdField_a_of_type_Stc.l.setLayoutParams(paramstc);
          }
          if (this.jdField_a_of_type_Stc.m != null)
          {
            paramstc = this.jdField_a_of_type_Stc.m;
            if (!this.jdField_a_of_type_Pxk.g()) {
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
      paramstc.setVisibility(paramInt);
      if ((!this.jdField_a_of_type_Pxk.g()) || (!this.jdField_a_of_type_Stc.a())) {
        break;
      }
      this.jdField_a_of_type_Stc.m.setOnClickListener(new qap(this));
      pmk.a().a(null);
      return;
      paramInt = 8;
      break label60;
      label715:
      paramInt = 8;
      break label130;
      paramstc = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841753);
      this.jdField_a_of_type_Stc.c.setCompoundDrawablesWithIntrinsicBounds(paramstc, null, null, null);
      break label206;
      paramInt = 8;
      break label238;
      label758:
      paramstc = this.jdField_a_of_type_Snh.b(l);
      break label335;
      paramstc = new SpannableString(str2);
      this.jdField_a_of_type_Stc.d.setVisibility(8);
      break label454;
      this.jdField_a_of_type_Stc.k.setVisibility(8);
      break label530;
      paramInt = 8;
      break label562;
    }
  }
  
  public void a(stc paramstc, pxk parampxk, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qam
 * JD-Core Version:    0.7.0.1
 */