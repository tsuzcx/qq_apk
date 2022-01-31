import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector.OnOrientationChangedListener;

public class lzr
  extends OrientationEventListener
{
  public lzr(OrientationDetector paramOrientationDetector, Context paramContext, OrientationDetector.OnOrientationChangedListener paramOnOrientationChangedListener)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (!OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, paramInt)) {}
    label136:
    for (;;)
    {
      return;
      int j = OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector);
      int i;
      if (((paramInt >= 0) && (paramInt <= 30)) || (paramInt > 330)) {
        i = 1;
      }
      for (;;)
      {
        if (i == OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector)) {
          break label136;
        }
        OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, i);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector$OnOrientationChangedListener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector$OnOrientationChangedListener.a(i);
        return;
        if ((paramInt > 70) && (paramInt <= 110))
        {
          i = 8;
        }
        else if ((paramInt > 150) && (paramInt <= 210))
        {
          i = 9;
        }
        else
        {
          i = j;
          if (paramInt > 250)
          {
            i = j;
            if (paramInt <= 290) {
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzr
 * JD-Core Version:    0.7.0.1
 */