import com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoFeedsListView;

public class moo
  implements Runnable
{
  public moo(FastWebVideoFeedsListView paramFastWebVideoFeedsListView) {}
  
  public void run()
  {
    FastWebVideoFeedsListView.a(this.a, true);
    this.a.smoothScrollBy(-FastWebVideoFeedsListView.d(this.a), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moo
 * JD-Core Version:    0.7.0.1
 */