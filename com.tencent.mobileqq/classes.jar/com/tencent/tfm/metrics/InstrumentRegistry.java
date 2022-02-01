package com.tencent.tfm.metrics;

import com.tencent.tfm.metrics.api.Measure;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InstrumentRegistry
{
  private final ConcurrentMap<String, AbstractInstrument> registry = new ConcurrentHashMap();
  
  <I extends Measure> I get(String paramString, Class<I> paramClass)
  {
    AbstractInstrument localAbstractInstrument = (AbstractInstrument)this.registry.get(paramString);
    if (localAbstractInstrument != null)
    {
      if (paramClass.isInstance(localAbstractInstrument)) {
        return (Measure)localAbstractInstrument;
      }
      throw new IllegalArgumentException(String.format("监控项类型不对： 监控项名称: %s, instrumentClazz : %s, found class: %s", new Object[] { paramString, paramClass.getName(), localAbstractInstrument.getClass().getName() }));
    }
    return null;
  }
  
  <I extends AbstractInstrument> I register(I paramI)
  {
    AbstractInstrument localAbstractInstrument = (AbstractInstrument)this.registry.putIfAbsent(paramI.getName(), paramI);
    if (localAbstractInstrument != null)
    {
      if (paramI.getClass().getName().equals(localAbstractInstrument.getClass().getName())) {
        return localAbstractInstrument;
      }
      throw new IllegalArgumentException(String.format("监控项已注册，且类型不匹配。 监控项名称: %s。 欲注册的类型 : %s。已注册的类型: %s", new Object[] { paramI.getName(), paramI.getClass().getName(), localAbstractInstrument.getClass().getName() }));
    }
    return paramI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tfm.metrics.InstrumentRegistry
 * JD-Core Version:    0.7.0.1
 */