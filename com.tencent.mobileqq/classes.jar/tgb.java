import com.tencent.qphone.base.util.QLog;

class tgb
  extends ssv
{
  tgb(tfz paramtfz) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    tfz.c(this.a, true);
    tfz localtfz;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        tfz.b(this.a);
      }
      localtfz = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localtfz.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryOIDBReceived:" + this.a.c);
      }
      return;
      label88:
      bool = false;
    }
  }
  
  public void b()
  {
    tcs localtcs = (tcs)tcz.a(10);
    this.a.b = ((Boolean)localtcs.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    tfz.a(this.a);
    tfz.a(this.a, true);
    tfz.a(this.a, true);
    tfz.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!tfz.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        tfz.a(this.a);
        tfz.a(this.a, true);
      }
      tfz.b(this.a, true);
      tfz.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tgb
 * JD-Core Version:    0.7.0.1
 */