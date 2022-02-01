package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import rx.Scheduler;

class AndroidSchedulers$MainThreadSchedulerHolder
{
  static final Scheduler MAIN_THREAD_SCHEDULER = new HandlerScheduler(new Handler(Looper.getMainLooper()));
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.android.schedulers.AndroidSchedulers.MainThreadSchedulerHolder
 * JD-Core Version:    0.7.0.1
 */