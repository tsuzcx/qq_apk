package cooperation.qwallet.plugin.ipc;

import android.os.Bundle;
import cooperation.qwallet.plugin.ICorpReq;

class CorpReq$2
  implements Runnable
{
  CorpReq$2(CorpReq paramCorpReq) {}
  
  public void run()
  {
    int i = CorpReq.corpReqType;
    Object localObject;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 5)
          {
            if (i != 6) {
              return;
            }
            CorpReq.access$000(this.this$0).deleteUserNickOB();
            return;
          }
          localObject = CorpReq.access$000(this.this$0).onTroopMemNick(this.this$0.troopUin, this.this$0.memUin, this.this$0.memUinArrayList, new CorpReq.2.1(this));
          if (localObject != null) {
            this.this$0.doCallback((Bundle)localObject);
          }
        }
        else
        {
          localObject = CorpReq.access$000(this.this$0).onUserNcik(this.this$0.uin, this.this$0.channel, this.this$0.groupId, this.this$0.fromReceiver);
          if (localObject != null) {
            this.this$0.doCallback((Bundle)localObject);
          }
        }
      }
      else
      {
        localObject = this.this$0;
        ((CorpReq)localObject).doCallback(CorpReq.access$000((CorpReq)localObject).onIsFriend(this.this$0.uin));
      }
    }
    else
    {
      localObject = this.this$0;
      ((CorpReq)localObject).doCallback(CorpReq.access$000((CorpReq)localObject).onGetFaceFilePath(this.this$0.faceType, this.this$0.uin, this.this$0.subType));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.ipc.CorpReq.2
 * JD-Core Version:    0.7.0.1
 */