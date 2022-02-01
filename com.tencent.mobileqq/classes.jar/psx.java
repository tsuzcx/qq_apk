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

public class psx
  implements psw
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ppu jdField_a_of_type_Ppu;
  private sel jdField_a_of_type_Sel;
  private sge jdField_a_of_type_Sge;
  private skg jdField_a_of_type_Skg;
  
  public psx(Context paramContext, sge paramsge, sel paramsel)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Sge = paramsge;
    this.jdField_a_of_type_Sel = paramsel;
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
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setOnClickListener(null);
      i += 1;
    }
    this.jdField_a_of_type_Skg.h.setOnClickListener(null);
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
    this.jdField_a_of_type_Skg.h.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
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
          Object localObject2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
          this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(new ptd(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setVisibility(0);
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[paramInt].setOnClickListener(new pte(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidViewView[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidViewView[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new ptb(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramPackJumpInfo.str_wording.get());
        this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramArticleInfo);
        this.jdField_a_of_type_Skg.h.setOnClickListener(paramArticleInfo);
        return;
      }
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setVisibility(0);
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setText(paramPackJumpInfo.str_wording.get());
      this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].setOnClickListener(paramArticleInfo);
      this.jdField_a_of_type_Skg.h.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new ptc(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setVisibility(0);
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.jdField_a_of_type_Skg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[3].setOnClickListener(paramPackJumpInfo);
    this.jdField_a_of_type_Skg.h.setOnClickListener(paramPackJumpInfo);
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
  
  public void a(skg paramskg, ppu paramppu, int paramInt)
  {
    int i = 0;
    this.jdField_a_of_type_Skg = paramskg;
    this.jdField_a_of_type_Ppu = paramppu;
    paramppu = this.jdField_a_of_type_Ppu.a();
    if (paramppu == null) {
      return;
    }
    label60:
    label206:
    label238:
    long l;
    label130:
    String str2;
    if (this.jdField_a_of_type_Skg.h != null)
    {
      paramskg = this.jdField_a_of_type_Skg.h;
      if (this.jdField_a_of_type_Ppu.b())
      {
        paramInt = 0;
        paramskg.setVisibility(paramInt);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Ppu.b())
      {
        this.jdField_a_of_type_Skg.b();
        a(this.jdField_a_of_type_Ppu.d(), paramppu);
      }
      if (this.jdField_a_of_type_Skg.i != null)
      {
        paramskg = this.jdField_a_of_type_Skg.i;
        if (!this.jdField_a_of_type_Ppu.c()) {
          break label715;
        }
        paramInt = 0;
        paramskg.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_Ppu.c())
      {
        this.jdField_a_of_type_Skg.c();
        this.jdField_a_of_type_Skg.c.setText(paramppu.mArticleFriendLikeText);
      }
      switch (paramppu.mCommentIconType)
      {
      default: 
        this.jdField_a_of_type_Skg.c.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (this.jdField_a_of_type_Skg.j != null)
        {
          paramskg = this.jdField_a_of_type_Skg.j;
          if (this.jdField_a_of_type_Ppu.d())
          {
            paramInt = 0;
            paramskg.setVisibility(paramInt);
          }
        }
        else
        {
          if (this.jdField_a_of_type_Ppu.d())
          {
            this.jdField_a_of_type_Skg.d();
            this.jdField_a_of_type_Skg.j.setOnClickListener(null);
            paramskg = (articlesummary.CommentInfo)paramppu.mCommentsObj.get(0);
            l = paramskg.uint64_uin.get();
            str2 = paramskg.str_content.get();
            String str1 = paramskg.str_jump_url.get();
            if (!ozs.a()) {
              break label758;
            }
            paramskg = bhlg.j((QQAppInterface)ozs.a(), String.valueOf(l));
            label335:
            String str3 = ozs.e(paramskg);
            if (str3 == null) {
              break label771;
            }
            paramskg = new SpannableString(str3 + ":  " + str2);
            paramskg.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167247)), 0, str3.length(), 33);
            this.jdField_a_of_type_Skg.d.setVisibility(0);
            this.jdField_a_of_type_Skg.d.setText(str3 + ":  ");
            label454:
            this.jdField_a_of_type_Skg.e.setText(paramskg);
            this.jdField_a_of_type_Skg.e.setOnClickListener(new psy(this, str1, paramppu));
            this.jdField_a_of_type_Skg.d.setOnClickListener(new psz(this, l, paramppu));
            if (!this.jdField_a_of_type_Ppu.f()) {
              break label796;
            }
            this.jdField_a_of_type_Skg.k.setVisibility(0);
          }
          label530:
          if (this.jdField_a_of_type_Skg.l != null)
          {
            paramskg = this.jdField_a_of_type_Skg.l;
            if (!this.jdField_a_of_type_Ppu.e()) {
              break label811;
            }
            paramInt = 0;
            label562:
            paramskg.setVisibility(paramInt);
          }
          if (this.jdField_a_of_type_Ppu.e())
          {
            paramskg = (LinearLayout.LayoutParams)this.jdField_a_of_type_Skg.l.getLayoutParams();
            qrc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Ppu, paramskg, this.jdField_a_of_type_Skg.l);
            this.jdField_a_of_type_Skg.l.setLayoutParams(paramskg);
          }
          if (this.jdField_a_of_type_Skg.m != null)
          {
            paramskg = this.jdField_a_of_type_Skg.m;
            if (!this.jdField_a_of_type_Ppu.g()) {
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
      paramskg.setVisibility(paramInt);
      if ((!this.jdField_a_of_type_Ppu.g()) || (!this.jdField_a_of_type_Skg.a())) {
        break;
      }
      this.jdField_a_of_type_Skg.m.setOnClickListener(new pta(this));
      pfd.a().a(null);
      return;
      paramInt = 8;
      break label60;
      label715:
      paramInt = 8;
      break label130;
      paramskg = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841763);
      this.jdField_a_of_type_Skg.c.setCompoundDrawablesWithIntrinsicBounds(paramskg, null, null, null);
      break label206;
      paramInt = 8;
      break label238;
      label758:
      paramskg = this.jdField_a_of_type_Sel.b(l);
      break label335;
      paramskg = new SpannableString(str2);
      this.jdField_a_of_type_Skg.d.setVisibility(8);
      break label454;
      this.jdField_a_of_type_Skg.k.setVisibility(8);
      break label530;
      paramInt = 8;
      break label562;
    }
  }
  
  public void a(skg paramskg, ppu paramppu, long paramLong, Bitmap paramBitmap) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psx
 * JD-Core Version:    0.7.0.1
 */