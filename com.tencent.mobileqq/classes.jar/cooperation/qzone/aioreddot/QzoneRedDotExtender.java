package cooperation.qzone.aioreddot;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutExtender;
import com.tencent.mobileqq.utils.ViewUtils;

public class QzoneRedDotExtender
  extends NickNameLayoutExtender
{
  private URLImageView mTroopQzoneView;
  
  public QzoneRedDotExtender(Context paramContext)
  {
    super(paramContext);
  }
  
  private void initQzoneRedDotViewIfNeed()
  {
    if (this.mTroopQzoneView == null)
    {
      int i = ViewUtils.b(15.0F);
      this.mTroopQzoneView = new URLImageView(this.mContext);
      this.mTroopQzoneView.setId(2131364563);
      this.mTroopQzoneView.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, i);
      localLayoutParams.leftMargin = ViewUtils.a(2.0F);
      localLayoutParams.bottomMargin = ViewUtils.a(0.5F);
      this.layoutParams = localLayoutParams;
    }
  }
  
  public BaseChatItemLayoutViewBasicAbility getBasicAbility()
  {
    if (this.ability == null) {
      this.ability = new QzoneRedDotExtender.1(this, this.mTroopQzoneView);
    }
    return this.ability;
  }
  
  public View getView()
  {
    initQzoneRedDotViewIfNeed();
    return this.mTroopQzoneView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.aioreddot.QzoneRedDotExtender
 * JD-Core Version:    0.7.0.1
 */