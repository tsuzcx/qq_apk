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
import com.tencent.mobileqq.utils.ContactUtils;
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

public class pyr
  implements pyq
{
  private Context jdField_a_of_type_AndroidContentContext;
  private pes jdField_a_of_type_Pes;
  private pvc jdField_a_of_type_Pvc;
  private slt jdField_a_of_type_Slt;
  private soh jdField_a_of_type_Soh;
  
  public pyr(Context paramContext, pes parampes, slt paramslt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Pes = parampes;
    this.jdField_a_of_type_Slt = paramslt;
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
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_Soh.h.setOnClickListener(null);
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
    this.jdField_a_of_type_Soh.h.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
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
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new pyx(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new pyy(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidViewView[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new pyv(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramArticleInfo);
        this.jdField_a_of_type_Soh.h.setOnClickListener(paramArticleInfo);
        return;
      }
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramArticleInfo);
      this.jdField_a_of_type_Soh.h.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new pyw(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_Soh.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_Soh.h.setOnClickListener(paramPackJumpInfo);
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
  
  public void a(soh paramsoh, pvc parampvc, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Soh = paramsoh;
    this.jdField_a_of_type_Pvc = parampvc;
    parampvc = this.jdField_a_of_type_Pvc.a();
    if (parampvc == null) {
      return;
    }
    label60:
    label206:
    label238:
    long l;
    label130:
    String str2;
    if (this.jdField_a_of_type_Soh.h != null)
    {
      paramsoh = this.jdField_a_of_type_Soh.h;
      if (this.jdField_a_of_type_Pvc.b())
      {
        paramInt = 0;
        paramsoh.setVisibility(paramInt);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Pvc.b())
      {
        this.jdField_a_of_type_Soh.b();
        a(this.jdField_a_of_type_Pvc.d(), parampvc);
      }
      if (this.jdField_a_of_type_Soh.i != null)
      {
        paramsoh = this.jdField_a_of_type_Soh.i;
        if (!this.jdField_a_of_type_Pvc.c()) {
          break label715;
        }
        paramInt = 0;
        paramsoh.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_Pvc.c())
      {
        this.jdField_a_of_type_Soh.c();
        this.jdField_a_of_type_Soh.c.setText(parampvc.mArticleFriendLikeText);
      }
      switch (parampvc.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_Soh.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (this.jdField_a_of_type_Soh.j != null)
        {
          paramsoh = this.jdField_a_of_type_Soh.j;
          if (this.jdField_a_of_type_Pvc.d())
          {
            paramInt = 0;
            paramsoh.setVisibility(paramInt);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Pvc.d())
          {
            this.jdField_a_of_type_Soh.d();
            this.jdField_a_of_type_Soh.j.setOnClickListener(null);
            paramsoh = (articlesummary.CommentInfo)parampvc.mCommentsObj.get(0);
            l = paramsoh.uint64_uin.get();
            str2 = paramsoh.str_content.get();
            String str1 = paramsoh.str_jump_url.get();
            if (!pay.a()) {
              break label758;
            }
            paramsoh = ContactUtils.getFriendDisplayName((QQAppInterface)pay.a(), String.valueOf(l));
            label335:
            String str3 = pay.e(paramsoh);
            if (str3 == null) {
              break label771;
            }
            paramsoh = new SpannableString(str3 + ":  " + str2);
            paramsoh.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167276)), 0, str3.length(), 33);
            this.jdField_a_of_type_Soh.d.setVisibility(0);
            this.jdField_a_of_type_Soh.d.setText(str3 + ":  ");
            label454:
            this.jdField_a_of_type_Soh.e.setText(paramsoh);
            this.jdField_a_of_type_Soh.e.setOnClickListener(new pys(this, str1, parampvc));
            this.jdField_a_of_type_Soh.d.setOnClickListener(new pyt(this, l, parampvc));
            if (!this.jdField_a_of_type_Pvc.f()) {
              break label796;
            }
            this.jdField_a_of_type_Soh.k.setVisibility(0);
          }
          label530:
          if (this.jdField_a_of_type_Soh.l != null)
          {
            paramsoh = this.jdField_a_of_type_Soh.l;
            if (!this.jdField_a_of_type_Pvc.e()) {
              break label811;
            }
            paramInt = 0;
            label562:
            paramsoh.setVisibility(paramInt);
          }
          if (this.jdField_a_of_type_Pvc.e())
          {
            paramsoh = (LinearLayout.LayoutParams)this.jdField_a_of_type_Soh.l.getLayoutParams();
            qxf.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Pvc, paramsoh, this.jdField_a_of_type_Soh.l);
            this.jdField_a_of_type_Soh.l.setLayoutParams(paramsoh);
          }
          if (this.jdField_a_of_type_Soh.m != null)
          {
            paramsoh = this.jdField_a_of_type_Soh.m;
            if (!this.jdField_a_of_type_Pvc.g()) {
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
      paramsoh.setVisibility(paramInt);
      if ((!this.jdField_a_of_type_Pvc.g()) || (!this.jdField_a_of_type_Soh.a())) {
        break;
      }
      this.jdField_a_of_type_Soh.m.setOnClickListener(new pyu(this));
      pkp.a().a(null);
      return;
      paramInt = 8;
      break label60;
      label715:
      paramInt = 8;
      break label130;
      paramsoh = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841805);
      this.jdField_a_of_type_Soh.c.setCompoundDrawablesWithIntrinsicBounds(paramsoh, null, null, null);
      break label206;
      paramInt = 8;
      break label238;
      label758:
      paramsoh = this.jdField_a_of_type_Slt.a(l);
      break label335;
      paramsoh = new SpannableString(str2);
      this.jdField_a_of_type_Soh.d.setVisibility(8);
      break label454;
      this.jdField_a_of_type_Soh.k.setVisibility(8);
      break label530;
      paramInt = 8;
      break label562;
    }
  }
  
  public void a(soh paramsoh, pvc parampvc, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyr
 * JD-Core Version:    0.7.0.1
 */