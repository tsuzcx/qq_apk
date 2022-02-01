package com.tencent.mobileqq.ecshop.view.adcard;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/ecshop/view/adcard/AdCardParseFactory$processorMap$1", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/ecshop/view/adcard/AdCardBaseProcessor;", "Lkotlin/collections/HashMap;", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class AdCardParseFactory$processorMap$1
  extends HashMap<Integer, AdCardBaseProcessor>
{
  AdCardParseFactory$processorMap$1()
  {
    AdCardMoreImageProcessor localAdCardMoreImageProcessor = new AdCardMoreImageProcessor();
    AdCardVideoProcessor localAdCardVideoProcessor = new AdCardVideoProcessor();
    AdCardQggProcessor localAdCardQggProcessor = new AdCardQggProcessor();
    put(Integer.valueOf(494), localAdCardMoreImageProcessor);
    put(Integer.valueOf(1662), localAdCardMoreImageProcessor);
    put(Integer.valueOf(185), localAdCardVideoProcessor);
    put(Integer.valueOf(433), localAdCardVideoProcessor);
    put(Integer.valueOf(1659), localAdCardVideoProcessor);
    put(Integer.valueOf(585), localAdCardVideoProcessor);
    put(Integer.valueOf(861), localAdCardVideoProcessor);
    put(Integer.valueOf(-1), localAdCardQggProcessor);
  }
  
  public final Set<Map.Entry<Integer, AdCardBaseProcessor>> entrySet()
  {
    return getEntries();
  }
  
  public Set getEntries()
  {
    return super.entrySet();
  }
  
  public Set getKeys()
  {
    return super.keySet();
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public Collection getValues()
  {
    return super.values();
  }
  
  public final Set<Integer> keySet()
  {
    return getKeys();
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public final Collection<AdCardBaseProcessor> values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.adcard.AdCardParseFactory.processorMap.1
 * JD-Core Version:    0.7.0.1
 */