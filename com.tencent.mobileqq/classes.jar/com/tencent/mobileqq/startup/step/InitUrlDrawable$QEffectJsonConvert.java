package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.jsonconverter.JSONConverter;
import com.tencent.qq.effect.engine.QEffectEngine.JsonConvert;

class InitUrlDrawable$QEffectJsonConvert
  implements QEffectEngine.JsonConvert
{
  public <T> T parseArray(String paramString, Class paramClass)
  {
    return JSONConverter.a(paramString, new InitUrlDrawable.QEffectJsonConvert.1(this).getClass().getGenericSuperclass());
  }
  
  public <T> T parseObject(String paramString, Class paramClass)
  {
    return JSONConverter.a(paramString, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable.QEffectJsonConvert
 * JD-Core Version:    0.7.0.1
 */