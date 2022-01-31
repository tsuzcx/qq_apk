import com.tencent.qphone.base.util.QLog;

class tge
  extends ssy
{
  tge(tgc paramtgc) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    tgc.c(this.a, true);
    tgc localtgc;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        tgc.b(this.a);
      }
      localtgc = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localtgc.a(bool);
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
    tcv localtcv = (tcv)tdc.a(10);
    this.a.b = ((Boolean)localtcv.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    tgc.a(this.a);
    tgc.a(this.a, true);
    tgc.a(this.a, true);
    tgc.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!tgc.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        tgc.a(this.a);
        tgc.a(this.a, true);
      }
      tgc.b(this.a, true);
      tgc.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tge
 * JD-Core Version:    0.7.0.1
 */