package cooperation.troop_homework;

import com.tencent.mobileqq.dpc.DPCObserver;

class HomeworkDpcCfg$1
  implements DPCObserver
{
  HomeworkDpcCfg$1(HomeworkDpcCfg paramHomeworkDpcCfg) {}
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.HomeworkDpcCfg.1
 * JD-Core Version:    0.7.0.1
 */