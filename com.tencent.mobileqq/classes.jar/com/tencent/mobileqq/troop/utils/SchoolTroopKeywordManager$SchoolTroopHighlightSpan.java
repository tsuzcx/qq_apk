package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.text.MessageFormat;

public class SchoolTroopKeywordManager$SchoolTroopHighlightSpan
  extends ClickableSpan
  implements ActionSheet.OnButtonClickListener
{
  private final Context a;
  private final SchoolTroopKeywordManager.KeywordResult b;
  private final QQAppInterface c;
  private ActionSheet d;
  
  public SchoolTroopKeywordManager$SchoolTroopHighlightSpan(QQAppInterface paramQQAppInterface, Context paramContext, SchoolTroopKeywordManager.KeywordResult paramKeywordResult)
  {
    this.c = paramQQAppInterface;
    this.a = paramContext;
    this.b = paramKeywordResult;
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Show", 0, 0);
  }
  
  private void a()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((ActionSheet)localObject1).isShowing())) {
      this.d.dismiss();
    }
    this.d = ((ActionSheet)ActionSheetHelper.b(this.a, null));
    Object localObject2 = this.b.b();
    localObject1 = localObject2;
    if (((String)localObject2).length() > 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((String)localObject2).substring(0, 5));
      ((StringBuilder)localObject1).append("…");
      ((StringBuilder)localObject1).append(((String)localObject2).substring(((String)localObject2).length() - 5, ((String)localObject2).length()));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject1 = MessageFormat.format(SchoolTroopKeywordManager.a()[this.b.d], new Object[] { localObject1 });
    localObject2 = LayoutInflater.from(this.a).inflate(2131624007, null);
    ((View)localObject2).setBackgroundDrawable(this.a.getResources().getDrawable(2130837682));
    ((View)localObject2).setOnClickListener(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.2(this));
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131427564);
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localObject1);
    localTextView.setContentDescription((CharSequence)localObject1);
    localTextView.setGravity(17);
    localTextView.setPadding(UIUtils.a(this.a, 10.0F), 0, UIUtils.a(this.a, 10.0F), 0);
    this.d.addViewCustomeTitle((View)localObject2);
    this.d.addButton(SchoolTroopKeywordManager.b()[this.b.d]);
    this.d.addCancelButton(HardCodeUtil.a(2131898212));
    this.d.setOnButtonClickListener(this);
    this.d.show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    ThreadManager.excute(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1(this, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2), 32, null, true);
  }
  
  public void onClick(View paramView)
  {
    if (BubbleContextMenu.a)
    {
      if (QLog.isColorLevel()) {
        QLog.e(SchoolTroopKeywordManager.a, 2, "SchoolTroopHighlightSpan onCLick is invoked by LongClick misstake");
      }
      return;
    }
    if ((paramView instanceof ETTextView)) {
      ((ETTextView)paramView).mHasClickedArkSpan = true;
    }
    a();
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Clk", 0, 0);
  }
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      Object localObject1 = null;
      Object localObject2 = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
      if (this.b.d == 1)
      {
        paramView = ((ITroopLinkApi)localObject2).getUrl("troop_homework_create_notice");
      }
      else if (this.b.d == 2)
      {
        paramView = ((ITroopLinkApi)localObject2).getUrl("troop_create_homework");
      }
      else
      {
        paramView = (View)localObject1;
        if (QLog.isColorLevel())
        {
          paramView = SchoolTroopKeywordManager.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("I don't know this action '");
          localStringBuilder.append(this.b.d);
          localStringBuilder.append("'");
          QLog.e(paramView, 2, localStringBuilder.toString());
          paramView = (View)localObject1;
        }
      }
      if (!TextUtils.isEmpty(paramView))
      {
        localObject1 = new ITroopLinkApi.LinkParams();
        ((ITroopLinkApi.LinkParams)localObject1).a = this.b.b;
        ((ITroopLinkApi.LinkParams)localObject1).c = "aio_keyword";
        ((ITroopLinkApi.LinkParams)localObject1).h = this.b.e;
        ((ITroopLinkApi.LinkParams)localObject1).i = this.b.b();
        paramView = ((ITroopLinkApi)localObject2).replaceParams(paramView, (ITroopLinkApi.LinkParams)localObject1);
        if (QLog.isDevelopLevel())
        {
          localObject1 = SchoolTroopKeywordManager.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("do action '");
          ((StringBuilder)localObject2).append(this.b.d);
          ((StringBuilder)localObject2).append("', open url: ");
          ((StringBuilder)localObject2).append(paramView);
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new Intent(this.a, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.a.startActivity((Intent)localObject1);
      }
      a("Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0);
    }
    paramView = this.d;
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan
 * JD-Core Version:    0.7.0.1
 */