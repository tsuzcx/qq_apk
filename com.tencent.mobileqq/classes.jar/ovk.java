import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.TimerTask;

public class ovk
  extends TimerTask
{
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ovk(TribeVideoPlugin paramTribeVideoPlugin, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramTribeVideoPlugin);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    Object localObject1 = (TribeVideoPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Object localObject2;
    if ((localObject1 == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("plugin == null ");
        if (localObject1 != null) {
          break label82;
        }
        bool = true;
        QLog.d("TribeVideoPlugin", 2, bool + " playerID = " + this.jdField_a_of_type_JavaLangString);
      }
    }
    label82:
    ovo localovo;
    label124:
    Object localObject3;
    do
    {
      do
      {
        return;
        bool = false;
        break;
        localovo = (ovo)TribeVideoPlugin.a((TribeVideoPlugin)localObject1).get(this.jdField_a_of_type_JavaLangString);
        if (localovo != null) {
          break label124;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TribeVideoPlugin", 2, "videoWrapper == null");
      return;
      localObject2 = ovo.a((ovo)TribeVideoPlugin.a((TribeVideoPlugin)localObject1).get(this.jdField_a_of_type_JavaLangString));
      localObject3 = ovo.a((ovo)TribeVideoPlugin.a((TribeVideoPlugin)localObject1).get(this.jdField_a_of_type_JavaLangString));
      if ((localObject2 != null) && (localObject3 != null)) {
        break label247;
      }
    } while (!QLog.isColorLevel());
    localObject1 = new StringBuilder().append("player == null ");
    if (localObject2 == null)
    {
      bool = true;
      localObject1 = ((StringBuilder)localObject1).append(bool).append(" layoutHolder == null ");
      if (localObject3 != null) {
        break label242;
      }
    }
    label242:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("TribeVideoPlugin", 2, bool);
      return;
      bool = false;
      break;
    }
    label247:
    long l1 = ((TVK_IMediaPlayer)localObject2).getDuration();
    long l2 = ((TVK_IMediaPlayer)localObject2).getCurrentPostion();
    if (ovm.a((ovm)localObject3) == 2)
    {
      SeekBar localSeekBar = ovm.a((ovm)localObject3);
      TextView localTextView1 = ovm.a((ovm)localObject3);
      TextView localTextView2 = ovm.b((ovm)localObject3);
      localObject3 = ovm.c((ovm)localObject3);
      VideoFeedsHelper.a(localTextView1, l1 - l2);
      VideoFeedsHelper.a(localTextView2, l2);
      VideoFeedsHelper.a((TextView)localObject3, l1);
      localSeekBar.setProgress((int)((float)l2 * 100.0F / (float)l1 + 0.5D));
    }
    for (;;)
    {
      if ((l2 <= 100L) && (!ovo.e(localovo)) && (((TVK_IMediaPlayer)localObject2).isPlaying()))
      {
        TribeVideoPlugin.a((TribeVideoPlugin)localObject1, this.jdField_a_of_type_JavaLangString, 1);
        ovo.e(localovo, true);
      }
      if ((ovo.b(localovo) - l2 > 100L) || (!ovo.e(localovo)) || (!((TVK_IMediaPlayer)localObject2).isPlaying())) {
        break;
      }
      TribeVideoPlugin.a((TribeVideoPlugin)localObject1, this.jdField_a_of_type_JavaLangString, 2);
      ovo.e(localovo, false);
      return;
      if (ovm.a((ovm)localObject3) == 1) {
        ovm.b((ovm)localObject3).setProgress((int)((float)l2 * 100.0F / (float)l1 + 0.5D));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovk
 * JD-Core Version:    0.7.0.1
 */