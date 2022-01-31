import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView;

public class mni
  implements Runnable
{
  public mni(FastWebVideoFeedsListView paramFastWebVideoFeedsListView) {}
  
  public void run()
  {
    FastWebVideoFeedsListView.a(this.a, true);
    this.a.smoothScrollBy(-FastWebVideoFeedsListView.d(this.a), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mni
 * JD-Core Version:    0.7.0.1
 */