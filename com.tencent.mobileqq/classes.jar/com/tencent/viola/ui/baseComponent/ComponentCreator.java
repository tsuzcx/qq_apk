package com.tencent.viola.ui.baseComponent;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.DomObject;

public abstract interface ComponentCreator
{
  public abstract VComponent createInstance(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentCreator
 * JD-Core Version:    0.7.0.1
 */