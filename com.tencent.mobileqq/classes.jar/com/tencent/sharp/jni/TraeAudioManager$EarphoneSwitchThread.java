package com.tencent.sharp.jni;

class TraeAudioManager$EarphoneSwitchThread
  extends TraeAudioManager.SwitchThread
{
  TraeAudioManager$EarphoneSwitchThread(TraeAudioManager paramTraeAudioManager, long paramLong)
  {
    super(paramTraeAudioManager, paramLong);
  }
  
  public String a()
  {
    return "DEVICE_EARPHONE";
  }
  
  public void a()
  {
    this.this$0.a(this.jdField_a_of_type_Long, TraeAudioManager.a(this.this$0), false);
    c();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (TraeAudioManager.a(this.this$0)) {
          this.this$0.a(this.jdField_a_of_type_Long, TraeAudioManager.a(this.this$0), false);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label77:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label77;
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.EarphoneSwitchThread
 * JD-Core Version:    0.7.0.1
 */