package cooperation.qwallet.plugin.ipc;

class CorpReq$1
  implements Runnable
{
  CorpReq$1(CorpReq paramCorpReq) {}
  
  public void run()
  {
    switch (CorpReq.corpReqType)
    {
    case 4: 
    default: 
      return;
    case 1: 
      this.this$0.onGetFaceFilePath();
      return;
    case 2: 
      this.this$0.onIsFriend();
      return;
    case 3: 
      this.this$0.onUserNcik();
      return;
    case 6: 
      this.this$0.deleteUserNickOB();
      return;
    }
    CorpReq.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq.1
 * JD-Core Version:    0.7.0.1
 */