import com.tencent.qphone.base.util.QLog;

class sti
  extends sgc
{
  sti(stg paramstg) {}
  
  public void a(byte paramByte)
  {
    boolean bool = true;
    this.a.a = paramByte;
    stg.c(this.a, true);
    stg localstg;
    if (paramByte != -1)
    {
      if (paramByte == 0) {
        stg.b(this.a);
      }
      localstg = this.a;
      if (paramByte != 2) {
        break label88;
      }
    }
    for (;;)
    {
      localstg.a(bool);
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
    spz localspz = (spz)sqg.a(10);
    this.a.b = ((Boolean)localspz.b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "commonConfigReceived:" + this.a.b);
    }
    stg.a(this.a);
    stg.a(this.a, true);
    stg.a(this.a, true);
    stg.b(this.a);
  }
  
  public void f(boolean paramBoolean)
  {
    if (!stg.a(this.a))
    {
      if (paramBoolean)
      {
        this.a.c = this.a.a();
        stg.a(this.a);
        stg.a(this.a, true);
      }
      stg.b(this.a, true);
      stg.b(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "onMsgTabStoryDPCCfgHasContentReceived:" + this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sti
 * JD-Core Version:    0.7.0.1
 */