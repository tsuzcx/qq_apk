import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView;

public class mne
  extends OrientationEventListener
{
  public mne(FastWebVideoFeedsListView paramFastWebVideoFeedsListView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    if (FastWebVideoFeedsListView.a(this.a)) {}
    label10:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                break label10;
                break label10;
                break label10;
                break label10;
                do
                {
                  return;
                } while ((!FastWebVideoFeedsListView.b(this.a)) || (FastWebVideoFeedsListView.a(this.a) == 1) || (!FastWebVideoFeedsListView.a(this.a, paramInt)) || (!FastWebVideoFeedsListView.c(this.a)));
                if ((paramInt < 0) || ((paramInt > 30) && (paramInt < 330))) {
                  break;
                }
              } while ((FastWebVideoFeedsListView.b(this.a) != -1) && (FastWebVideoFeedsListView.b(this.a) != 0));
              FastWebVideoFeedsListView.a(this.a, -1);
            } while (FastWebVideoFeedsListView.c(this.a) == 0);
            this.a.e();
            return;
            if ((paramInt < 70) || (paramInt > 110)) {
              break;
            }
          } while ((FastWebVideoFeedsListView.b(this.a) != -1) && (FastWebVideoFeedsListView.b(this.a) != 2));
          FastWebVideoFeedsListView.a(this.a, -1);
        } while (FastWebVideoFeedsListView.c(this.a) == 2);
        FastWebVideoFeedsListView.a(this.a, 2);
        return;
      } while ((paramInt < 250) || (paramInt > 290) || ((FastWebVideoFeedsListView.b(this.a) != -1) && (FastWebVideoFeedsListView.b(this.a) != 1)));
      FastWebVideoFeedsListView.a(this.a, -1);
    } while (FastWebVideoFeedsListView.c(this.a) == 1);
    FastWebVideoFeedsListView.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mne
 * JD-Core Version:    0.7.0.1
 */