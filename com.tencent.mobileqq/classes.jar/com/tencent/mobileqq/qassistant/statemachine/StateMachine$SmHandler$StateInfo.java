package com.tencent.mobileqq.qassistant.statemachine;

class StateMachine$SmHandler$StateInfo
{
  State a;
  StateInfo b;
  boolean c;
  
  private StateMachine$SmHandler$StateInfo(StateMachine.SmHandler paramSmHandler) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state=");
    localStringBuilder.append(this.a.d());
    localStringBuilder.append(",active=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",parent=");
    Object localObject = this.b;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = ((StateInfo)localObject).a.d();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.statemachine.StateMachine.SmHandler.StateInfo
 * JD-Core Version:    0.7.0.1
 */