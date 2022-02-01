package com.tencent.mobileqq.relationx.icebreaking;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecData;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CustomImgView;

class AIOIceBreakView$2
  implements View.OnClickListener
{
  AIOIceBreakView$2(AIOIceBreakView paramAIOIceBreakView) {}
  
  public void onClick(View paramView)
  {
    QLog.i("IceBreak.HotPic", 2, "onClick.");
    Object localObject = (IStickerRecEmoticon)paramView.getTag();
    if (AIOIceBreakView.c(this.a) != null)
    {
      AIOIceBreakView.c(this.a).a(paramView);
      IceBreakingMng.b = true;
      if ((localObject instanceof StickerRecData)) {
        this.a.a(paramView, "clck", (StickerRecData)localObject);
      }
    }
    if ((paramView instanceof CustomImgView))
    {
      URLImageView localURLImageView = (URLImageView)((CustomImgView)paramView).a;
      if ((localURLImageView.getDrawable() instanceof URLDrawable)) {
        if (((URLDrawable)localURLImageView.getDrawable()).getStatus() == 1) {
          AIOIceBreakView.a(this.a, (IStickerRecEmoticon)localObject);
        } else if (QLog.isColorLevel()) {
          QLog.e("IceBreak.HotPic", 2, "onClick:URLDrawable status != successed");
        }
      }
    }
    else
    {
      AIOIceBreakView.d(this.a);
      IceBreakingUtil.a(IceBreakingUtil.Event.EMOJI_CLK);
    }
    if (AIOIceBreakView.e(this.a) >= 3) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    int i = IceBreakingUtil.a(AIOIceBreakView.b(this.a), AIOIceBreakView.a(this.a).ah);
    ReportController.b(AIOIceBreakView.b(this.a), "CliOper", "", "", "0X800B577", "0X800B577", i, 0, (String)localObject, "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.2
 * JD-Core Version:    0.7.0.1
 */