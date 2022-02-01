package com.tencent.tkd.comment.publisher.qq;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.tkd.comment.publisher.qq.model.TkdQQArgument;
import org.json.JSONObject;

class QQPublishCommentFragment$BiuUi
  implements View.OnClickListener, QQPublishCommentFragment.OnGifChangeListener
{
  private boolean hasPicData;
  boolean isSelected;
  private final ImageView vBiuImageView;
  private final LinearLayout vBiuLayout;
  
  QQPublishCommentFragment$BiuUi(QQPublishCommentFragment paramQQPublishCommentFragment, Dialog paramDialog)
  {
    this.vBiuImageView = ((ImageView)paramDialog.findViewById(R.id.k));
    this.vBiuLayout = ((LinearLayout)paramDialog.findViewById(R.id.i));
    this.vBiuLayout.setVisibility(8);
  }
  
  private void onBiuButton()
  {
    if (this.hasPicData)
    {
      QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
      localQQPublishCommentFragment.showToast(localQQPublishCommentFragment.getActivity().getString(R.string.a), 0);
      return;
    }
    if (!this.isSelected)
    {
      this.vBiuImageView.setImageResource(R.drawable.b);
      this.isSelected = true;
    }
    else
    {
      this.vBiuImageView.setImageResource(R.drawable.a);
      this.isSelected = false;
    }
    reportClickBiu();
  }
  
  private void reportClickBiu()
  {
    QQPublishCommentFragment localQQPublishCommentFragment = this.this$0;
    String str;
    if (this.isSelected) {
      str = "0";
    } else {
      str = "1";
    }
    QQPublishCommentFragment.access$1400(localQQPublishCommentFragment, "", "0X8008F58", "0X8008F58", str, "", "", QQPublishCommentFragment.access$1900(this.this$0, false));
  }
  
  void hide()
  {
    this.vBiuLayout.setVisibility(8);
  }
  
  void initData()
  {
    if (!QQPublishCommentFragment.access$1200(this.this$0).showBiu) {
      return;
    }
    this.vBiuLayout.setVisibility(0);
    this.vBiuLayout.setOnClickListener(this);
    if (QQPublishCommentFragment.access$1200(this.this$0).selectBiu)
    {
      this.vBiuImageView.setImageResource(R.drawable.b);
      this.isSelected = true;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.vBiuLayout) {
      onBiuButton();
    }
  }
  
  public void onGifDelete(boolean paramBoolean)
  {
    this.hasPicData = false;
    this.vBiuImageView.setClickable(true);
    if (paramBoolean) {
      this.vBiuImageView.setImageResource(R.drawable.b);
    }
  }
  
  public boolean onGifSelected()
  {
    this.hasPicData = true;
    if (this.isSelected) {
      this.vBiuImageView.setImageResource(R.drawable.a);
    }
    return this.isSelected;
  }
  
  void packageDataInfo(JSONObject paramJSONObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.qq.QQPublishCommentFragment.BiuUi
 * JD-Core Version:    0.7.0.1
 */