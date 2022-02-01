package cooperation.qzone.aioreddot;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.utils.ViewUtils;

public class QcircleRedDotExtender
  extends NickNameLayoutExtender
{
  private URLImageView mTroopQcircleView;
  
  public QcircleRedDotExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void initQcircleRedDotViewIfNeed()
  {
    if (this.mTroopQcircleView == null)
    {
      int i = ViewUtils.dpToPx(15.0F);
      int j = ViewUtils.dpToPx(22.0F);
      this.mTroopQcircleView = new URLImageView(this.mContext);
      this.mTroopQcircleView.setId(2131430621);
      this.mTroopQcircleView.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, i);
      localLayoutParams.leftMargin = ViewUtils.dip2px(2.0F);
      this.layoutParams = localLayoutParams;
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new QcircleRedDotExtender.1(this, this.mTroopQcircleView);
    }
    return this.ability;
  }
  
  public View getView()
  {
    initQcircleRedDotViewIfNeed();
    return this.mTroopQcircleView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.aioreddot.QcircleRedDotExtender
 * JD-Core Version:    0.7.0.1
 */