import android.content.Context;
import android.content.res.Resources;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.av.ui.BeautyToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.widget.BidirectionSeekBar;

public class jrh
  implements SeekBar.OnSeekBarChangeListener
{
  public jrh(BeautyToolbar paramBeautyToolbar) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (this.a.mBeautyValue != paramInt)
    {
      this.a.applyBeautyValue(paramInt);
      this.a.updateTip(paramInt);
      if ((paramInt != 0) || (this.a.mBeautyValue <= 0)) {
        break label142;
      }
      this.a.mSeek.setThumb(this.a.mThumb_0);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.a.mSeek.setContentDescription(this.a.mContext.getResources().getString(2131429254) + paramInt + "%");
      }
      this.a.mBeautyValue = paramInt;
      this.a.applyBeautyValue(this.a.mBeautyValue);
      EffectSettingUi.a(this.a.mApp);
      return;
      label142:
      if ((paramInt > 0) && (paramInt <= 30) && ((this.a.mBeautyValue <= 0) || (this.a.mBeautyValue > 30))) {
        this.a.mSeek.setThumb(this.a.mThumb_30);
      } else if ((paramInt > 30) && (paramInt <= 60) && ((this.a.mBeautyValue <= 30) || (this.a.mBeautyValue > 60))) {
        this.a.mSeek.setThumb(this.a.mThumb_60);
      } else if ((paramInt > 60) && (paramInt <= 100) && ((this.a.mBeautyValue <= 60) || (this.a.mBeautyValue > 100))) {
        this.a.mSeek.setThumb(this.a.mThumb_100);
      }
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    EffectSettingUi.a(this.a.mApp);
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    EffectSettingUi.a(this.a.mApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrh
 * JD-Core Version:    0.7.0.1
 */